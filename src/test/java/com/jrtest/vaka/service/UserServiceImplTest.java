package com.jrtest.vaka.service;

import com.jrtest.vaka.dao.BaseDao;
import com.jrtest.vaka.dao.UserDao;
import com.jrtest.vaka.model.User;
import com.jrtest.vaka.service.impl.UserServiceImpl;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.joda.time.LocalDateTime;


/**
 * @author Iaroslav
 * @since 22.12.2014 20:56
 */
public class UserServiceImplTest extends CrudServiceTest<User> {
    @Tested
    private UserServiceImpl userService;
    @Injectable
    @Mocked
    private UserDao userDao;

    @Override
    protected CrudService<User> getService() {
        return userService;
    }

    @Override
    protected BaseDao<User> getMockedDao() {
        return userDao;
    }

    @Override
    protected User createEntity() {
        User user = new User();
        user.setName("Vaka");
        user.setAge((int) (Math.random() * 150));
        user.setCreatedDate(LocalDateTime.now().withMillisOfSecond(0));
        return user;
    }
}
