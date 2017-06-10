package com.koou.service.impl;

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
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserInfo getByUsername(String username) {
        return userAdminMapper.selectUserInfoByUsername(username);
    }
}
