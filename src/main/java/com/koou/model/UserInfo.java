package com.koou.model;

import com.koou.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-08 1:29 PM
 */
public class UserInfo extends User {

    @Getter
    @Setter
    List<String> roles;

    public UserInfo() {
    }

    public UserInfo(String username, String password, String uuid) {
        super(null, username, password, null, null, uuid);
    }

    public UserInfo(Long id, String username, String password, Date loginDate, Date lastPasswordResetDate, String uuid, List<String> roles) {
        super(id, username, password, loginDate, lastPasswordResetDate, uuid);
        this.roles = roles;
    }
}
