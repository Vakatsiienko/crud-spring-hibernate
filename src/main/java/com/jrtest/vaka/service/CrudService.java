package com.jrtest.vaka.service;

import com.jrtest.vaka.model.BaseEntity;

/**
 * @author Iaroslav
 * @since 22.12.2014 20:39
 */
public interface CrudService<Entity extends BaseEntity> {
    Entity create(Entity entity);

    Entity read(int id);

    Entity update(int id, Entity entity);

    boolean delete(int id);
}
