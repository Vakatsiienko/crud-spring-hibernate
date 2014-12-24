package com.jrtest.vaka.controller.impl;

import com.jrtest.vaka.controller.BaseCrudController;
import com.jrtest.vaka.model.User;
import com.jrtest.vaka.service.CrudService;
import com.jrtest.vaka.service.UserService;
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
