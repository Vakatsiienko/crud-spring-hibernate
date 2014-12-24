package com.jrtest.vaka.dao;

import com.jrtest.vaka.PersistenceTest;
import com.jrtest.vaka.model.BaseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Iaroslav
 * @since 20.12.2014 15:39
 */
public abstract class BaseDaoTest<Entity extends BaseEntity> extends PersistenceTest {
    @Test
    public void testCreate() {
        Entity e = createEntity();
        Entity created = getDao().create(e);

        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getId());
    }

    @Test
    public void testRead() {
        Entity created = getDao().create(createEntity());
        Entity read = getDao().read(created.getId());

        Assert.assertNotNull(read);
        Assert.assertEquals(read, created);

    }

    @Test
    public void testUpdate() {
        Entity oldEntity = getDao().create(createEntity());
        Entity newEntity = createEntity();
        Entity updated = getDao().update(oldEntity.getId(), newEntity);

        Assert.assertNotNull(updated);
        Assert.assertEquals(newEntity, updated);
    }

    @Test
    public void testDelete() {
        Entity e = getDao().create(createEntity());

        boolean deleted = getDao().delete(e.getId());
        Assert.assertTrue(deleted);

        Entity entity = getDao().read(e.getId());
        Assert.assertNull(entity);
    }

    protected abstract BaseDao<Entity> getDao();

    protected abstract Entity createEntity();
}
