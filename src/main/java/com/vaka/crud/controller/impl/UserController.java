package com.vaka.crud.controller.impl;

import com.vaka.crud.controller.BaseCrudController;
import com.vaka.crud.model.User;
import com.vaka.crud.service.CrudService;
import com.vaka.crud.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @author Iaroslav
 * @since 22.12.2014 21:56
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseCrudController<User> {
    @Inject
    private UserService userService;

    @Override
    public CrudService<User> getService() {
        return userService;
    }
}
