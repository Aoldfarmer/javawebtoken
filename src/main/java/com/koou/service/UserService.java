package com.koou.service;

import com.koou.dto.response.UserListResponseDto;

import java.util.List;

/**
 * Description: user类Service.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 4:58 PM
 */
public interface UserService {

    List<UserListResponseDto> queryUserList();
}
