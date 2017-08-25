package com.koou.admin.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-08-25 11:04 AM
 */
@Data
@AllArgsConstructor
public class LoginResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String token;
}
