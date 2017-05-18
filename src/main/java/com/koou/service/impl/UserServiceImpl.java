package com.koou.service.impl;

import com.koou.domain.User;
import com.koou.dto.response.Hero;
import com.koou.repository.UserMapper;
import com.koou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Hero> queryAll() {
        return userMapper.queryAll();
    }
}
