package com.jrtest.vaka.dao.impl;

import com.jrtest.vaka.dao.UserDao;
import com.jrtest.vaka.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iaroslav
 * @since 20.12.2014 15:36
 */
@Deprecated
public class UserDaoHashMap implements UserDao {
    private Map<Integer, User> users = new HashMap<>();

    @Override
    public User create(User entity) {
        int id = (int) (Math.random() * Integer.MAX_VALUE);
        entity.setId(id);
        users.put(id, entity);
        return entity;
    }

    @Override
    public User read(int id) {
        return users.get(id);
    }

    @Override
    public User update(int id, User entity) {
        entity.setId(id);
        users.put(id, entity);
        return entity;
    }

    @Override
    public boolean delete(int id) {
        User remove = users.remove(id);
        return remove != null;
    }
}
