package com.koou.service.impl;

import com.koou.dao.UserDao;
import com.koou.dto.response.UserListResponseDto;
import com.koou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: userService实现.
 *
 * @author yunqiangdi
 * @version 1.0
 * @date 2017-05-10 4:59 PM
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserListResponseDto> queryUserList() {
        return userDao.queryUserList();
    }
}
