package com.jrtest.vaka.service.impl;

import com.jrtest.vaka.dao.BaseDao;
import com.jrtest.vaka.dao.UserDao;
import com.jrtest.vaka.model.User;
import com.jrtest.vaka.service.BaseCrudService;
import com.jrtest.vaka.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


/**
 * @author Iaroslav
 * @since 22.12.2014 20:44
 */
@Service
public class UserServiceImpl extends BaseCrudService<User> implements UserService {
    @Inject
    private UserDao dao;

    @Override
    public BaseDao<User> getDao() {
        return dao;
    }
}
