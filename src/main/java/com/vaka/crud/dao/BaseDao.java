package com.vaka.crud.dao;

import com.vaka.crud.model.BaseEntity;

import java.util.List;

/**
 * @author Iaroslav
 * @since 20.12.2014 15:31
 */
public interface BaseDao<T extends BaseEntity> {
    T create(T entity);

    T read(int id);

    T update(int id, T entity);

    boolean delete(int id);

    Page<T> readPage(int offset, int size);

}