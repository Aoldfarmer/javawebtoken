package com.koou.service;

import com.koou.domain.User;
import org.springframework.security.access.prepost.PreAuthorize;


/**
 * Description: user类Service.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 4:58 PM
 */
public interface UserService {

    void addUser(User user);

    @PreAuthorize("hasAuthority('ROLE_USER')")
    User getUserByPrimaryKey(long id);

}
