package com.vaka.crud.service;

import com.vaka.crud.dao.BaseDao;
import com.vaka.crud.dao.Page;
import com.vaka.crud.model.BaseEntity;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author Iaroslav
 * @since 22.12.2014 20:41
 */
public abstract class BaseCrudService<Entity extends BaseEntity> implements CrudService<Entity> {
    public abstract BaseDao<Entity> getDao();

    @Override
    public Entity create(Entity entity) {
        entity.setCreatedDate(Timestamp.from(Instant.now()));
        return getDao().create(entity);
    }

    @Override
    public Entity read(int id) {
        return getDao().read(id);
    }

    @Override
    public Page<Entity> readPage(int offset, int size) {
        return getDao().readPage(offset, size);
    }

    @Override
    public Entity update(int id, Entity entity) {
        return getDao().update(id, entity);
    }

    @Override
    public boolean delete(int id) {
        return getDao().delete(id);
    }
}
