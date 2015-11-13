package com.jrtest.vaka.dao;

import com.jrtest.vaka.model.User;
import org.joda.time.LocalDateTime;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author Iaroslav
 * @since 20.12.2014 15:41
 */
public class UserDaoImplTest extends BaseDaoTest<User> {
    @Inject
    private UserDao dao;

    @Override
    protected BaseDao<User> getDao() {
        return dao;
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
