package com.vaka.crud.service;

import com.vaka.crud.dao.Page;
import com.vaka.crud.model.BaseEntity;

import java.util.List;

/**
 * @author Iaroslav
 * @since 22.12.2014 20:39
 */
public interface CrudService<Entity extends BaseEntity> {
    Entity create(Entity entity);

    Entity read(int id);

    Entity update(int id, Entity entity);

    boolean delete(int id);

    Page<Entity> readPage(int offset, int size);
}
