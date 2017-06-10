package com.koou.repository;

import org.apache.ibatis.annotations.Param;

import com.koou.model.UserInfo;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-07 7:42 PM
 */
public interface UserAdminMapper {

    UserInfo selectUserInfoByUsername(@Param("username") String username);
}
