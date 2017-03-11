package com.vaka.crud.controller;

import com.vaka.crud.controller.impl.UserController;
import com.vaka.crud.model.User;
import com.vaka.crud.service.CrudService;
import com.vaka.crud.service.UserService;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author Iaroslav
 * @since 27.12.2014 16:58
 */
public class UserControllerTest extends BaseCrudControllerTest<User> {
    @Tested
    private UserController userController;
    @Injectable
    @Mocked
    private UserService userService;
    @Override
    protected BaseCrudController<User> getController() {
        return userController;
    }

    @Override
    protected CrudService<User> getMockedService() {
        return userService;
    }

    @Override
    protected User createEntity() {
        User user = new User();
        user.setName("Vaka");
        user.setAge((int) (Math.random() * 150));
        Timestamp time = Timestamp.from(Instant.now());
        time.setNanos(0);
        user.setCreatedDate(time);
        return user;
    }

}


