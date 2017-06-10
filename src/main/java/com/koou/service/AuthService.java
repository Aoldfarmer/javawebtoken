package com.koou.service;

import com.koou.domain.User;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-08 2:29 PM
 */
public interface AuthService {

    void register(User user);

    String login(String username, String password);

    String refresh(String token);
}
