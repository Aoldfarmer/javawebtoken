package com.koou.model;

import com.koou.domain.User;
import lombok.Getter;
import lombok.Setter;

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
}
