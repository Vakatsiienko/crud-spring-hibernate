package com.vaka.crud.service.impl;

import com.vaka.crud.dao.BaseDao;
import com.vaka.crud.dao.UserDao;
import com.vaka.crud.model.User;
import com.vaka.crud.service.BaseCrudService;
import com.vaka.crud.service.UserService;
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
