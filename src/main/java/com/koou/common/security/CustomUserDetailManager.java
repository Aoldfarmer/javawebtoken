package com.koou.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.koou.service.UserService;

/**
 * Description: 数据库匹配登陆信息.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-06 5:53 PM
 */
@Component
public class CustomUserDetailManager implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userService.getByUserName(username);
    }
}
