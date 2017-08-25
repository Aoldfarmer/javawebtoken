package com.koou.admin.base.service;

import com.koou.common.domain.User;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-08 2:29 PM
 */
public interface AuthService {

    User register(String username, String password);

    String login(String username, String password);

    String refresh(String token);
}
