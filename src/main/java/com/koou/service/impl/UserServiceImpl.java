package com.koou.service.impl;

import com.koou.domain.User;
import com.koou.model.UserDetail;
import com.koou.repository.UserAdminMapper;
import com.koou.repository.UserMapper;
import com.koou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserDetail getByUserName(String userName) {
        User foundUser =  userAdminMapper.selectByUserName(userName);
        UserDetail userDetail = new UserDetail();
        userDetail.setId(foundUser.getId());
        userDetail.setUsername(foundUser.getUsername());
        userDetail.setLoginDate(foundUser.getLoginDate());
        userDetail.setPassword(foundUser.getPassword());
        return userDetail;
    }
}
