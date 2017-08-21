package com.koou.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koou.domain.User;
import com.koou.model.UserInfo;
import com.koou.repository.UserAdminMapper;
import com.koou.repository.UserMapper;
import com.koou.service.UserService;

/**
 * Description: userService实现.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 4:59 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAdminMapper userAdminMapper;

    @Override
    public UserInfo addUser(String username, String password) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        userAdminMapper.insertUser(username, password, uuid);
        return new UserInfo(username, password, uuid);
    }

    @Override
    public User getById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserInfo getByUUID(String uuid) {
        return userAdminMapper.selectUserInfoByUuid(uuid);
    }

    @Override
    public UserInfo getByUsername(String username) {
        return userAdminMapper.selectUserInfoByUsername(username);
    }
}
