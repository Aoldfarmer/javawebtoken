package com.koou.admin.base.service;

import com.koou.common.model.UserInfo;


/**
 * Description: user类Service.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 4:58 PM
 */
public interface UserService {

    UserInfo addUser(String username, String password);

    UserInfo getByUUID(String uuid);

    UserInfo getByUsername(String username);
}
