package com.koou.common.security.service;

import com.koou.admin.base.service.UserService;
import com.koou.common.factory.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.koou.common.model.UserInfo;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-08 1:37 PM
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userService.getByUsername(username);

        if (userInfo == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(userInfo);
        }
    }
}
