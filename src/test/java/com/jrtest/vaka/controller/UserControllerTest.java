package com.jrtest.vaka.controller;

import com.jrtest.vaka.controller.impl.UserController;
import com.jrtest.vaka.model.User;
import com.jrtest.vaka.service.CrudService;
import com.jrtest.vaka.service.UserService;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.joda.time.LocalDateTime;

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


