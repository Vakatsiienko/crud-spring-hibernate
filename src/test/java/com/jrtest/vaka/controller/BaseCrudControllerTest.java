package com.jrtest.vaka.controller;

import com.jrtest.vaka.model.BaseEntity;
import com.jrtest.vaka.service.CrudService;
import mockit.Expectations;
import mockit.Verifications;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Iaroslav
 * @since 27.12.2014 16:57
 */
public abstract class BaseCrudControllerTest<Entity extends BaseEntity> extends ControllerTest {
    @Test
    public void testCreate() {
        final Entity e = createEntity();
        getController().create(e);
        new Verifications(){{
            getMockedService().create(e);
        }};
    }

    @Test
    public void testRead(){
        final Entity created = createEntity();
        final CrudService<Entity> service = getMockedService();

        new Expectations() {{
            service.read(1);
            returns(created);
        }};

        ResponseEntity read = getController().read(1);

        Assert.assertNotNull(read);
        Assert.assertEquals(read.content, created);
    }

    @Test
    public void testUpdate(){
        final Entity oldEntity = createEntity();
        final Entity newEntity = createEntity();
        Entity make = newEntity;
        make.setCreatedDate(oldEntity.getCreatedDate());
        final Entity entity = make;
        final CrudService<Entity> service = getMockedService();
        new Expectations() {{
            service.update(oldEntity.getId(), newEntity);
            returns(entity);
        }};
        ResponseEntity<Entity> e = getController().update(oldEntity.getId(), newEntity);
        Assert.assertEquals(e.content, entity);
    }

    @Test
    public void testDelete(){
        final CrudService<Entity> dao = getMockedService();
        final Entity e = createEntity();
        final Boolean deleted = true;
        new Expectations(){{
            dao.delete(e.getId());
            returns(deleted);
        }};
        ResponseEntity<Boolean> b = getController().delete(e.getId());
        Assert.assertEquals(b.content, deleted);
    }
    protected abstract BaseCrudController<Entity> getController();

    protected abstract CrudService<Entity> getMockedService();

    protected abstract Entity createEntity();
}
