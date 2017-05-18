package com.koou.service;

import com.koou.domain.User;
import com.koou.dto.response.Hero;

import java.util.List;

/**
 * Description: user类Service.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 4:58 PM
 */
public interface UserService {

    void addUser(User user);

    User getUserByPrimaryKey(int id);

    List<Hero> queryAll();
}
