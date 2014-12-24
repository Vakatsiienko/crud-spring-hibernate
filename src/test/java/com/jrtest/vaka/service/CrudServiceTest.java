package com.jrtest.vaka.service;

import com.jrtest.vaka.dao.BaseDao;
import com.jrtest.vaka.model.BaseEntity;
import mockit.Expectations;
import mockit.Verifications;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Iaroslav
 * @since 22.12.2014 20:50
 */
public abstract class CrudServiceTest<Entity extends BaseEntity> extends ServiceTest {
    @Test
    public void testCreate() {
        final Entity e = createEntity();
        getService().create(e);

        new Verifications() {{
            getMockedDao().create(e);
        }};
    }

    @Test
    public void testRead() {
        final Entity created = createEntity();
        final BaseDao<Entity> dao = getMockedDao();

        new Expectations() {{
            dao.read(1);
            returns(created);
        }};

        Entity read = getService().read(1);

        Assert.assertNotNull(read);
        Assert.assertEquals(read, created);
    }
/*
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
    }*/

    protected abstract CrudService<Entity> getService();

    protected abstract BaseDao<Entity> getMockedDao();

    protected abstract Entity createEntity();
}
