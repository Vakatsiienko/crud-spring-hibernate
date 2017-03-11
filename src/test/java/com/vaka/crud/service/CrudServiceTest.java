package com.vaka.crud.service;

import com.vaka.crud.dao.BaseDao;
import com.vaka.crud.model.BaseEntity;
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

    @Test
    public void testUpdate() {
        final Entity oldEntity = createEntity();
        final Entity newEntity = createEntity();
        Entity make = newEntity;
        make.setCreatedDate(oldEntity.getCreatedDate());
        final Entity entity = make;
        final BaseDao<Entity> dao = getMockedDao();
        new Expectations() {{
            dao.update(oldEntity.getId(), newEntity);
            returns(entity);
        }};
        Entity e = getService().update(oldEntity.getId(), newEntity);
        Assert.assertEquals(e, entity);
    }

    @Test
    public void testDelete() {
        final BaseDao<Entity> dao = getMockedDao();
        final Entity e = createEntity();
        final boolean deleted = true;
        new Expectations(){{
            dao.delete(e.getId());
            returns(deleted);
        }};
        boolean b = getService().delete(e.getId());
        Assert.assertEquals(b, deleted);
    }

    protected abstract CrudService<Entity> getService();

    protected abstract BaseDao<Entity> getMockedDao();

    protected abstract Entity createEntity();
}
