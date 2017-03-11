package com.vaka.crud.dao.impl;

import com.vaka.crud.dao.Page;
import com.vaka.crud.dao.UserDao;
import com.vaka.crud.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Iaroslav
 * @since 22.12.2014 19:19
 */
@Component
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User create(User entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public User read(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User update(int id, User entity) {
        entity.setId(id);
        return em.merge(entity);
    }

    @Override
    public boolean delete(int id) {
        User entity = em.find(User.class, id);
        if (entity != null) {
            em.remove(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<User> readPage(int page, int size) {
        List entities = em.createQuery("select u from user u").getResultList();
        long length = (long) em.createQuery("select count(u) from user u").getSingleResult();
        return new Page(entities, length);
    }


}
