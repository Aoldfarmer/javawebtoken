package com.koou.repository;

import com.koou.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-07 7:42 PM
 */
public interface UserAdminMapper {

    User selectByUserName(@Param("userName") String userName);
}
