package com.koou.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @date 2017-05-10 5:03 PM
 */
@Data
public class UserListResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int userId;

    private String userName;

}
