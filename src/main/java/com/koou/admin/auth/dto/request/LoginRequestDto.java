package com.koou.admin.auth.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-08 2:57 PM
 */
@Data
public class LoginRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;
}
