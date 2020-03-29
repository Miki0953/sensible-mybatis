package com.sensible.mapper;

import com.sensible.model.User;

/**
 * @author liuyc
 * @Description:
 * @date 2020/3/29 00291:00
 */
public interface UserMapper {
    Long addUser(User user);

    Boolean delUser(Integer id);

    Integer updateUser(User user);

    User getUserById(Integer id);
}
