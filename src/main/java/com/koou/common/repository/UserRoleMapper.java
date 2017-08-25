package com.koou.common.repository;

import com.koou.common.domain.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}