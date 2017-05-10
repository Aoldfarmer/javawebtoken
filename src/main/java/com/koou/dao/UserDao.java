package com.koou.dao;

import com.koou.dto.response.UserListResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description: user操作数据库类.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 4:56 PM
 */
@Mapper
public interface UserDao {

    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
    })

    @Select(value = "select user_id, user_name from t_user")
    List<UserListResponseDto> queryUserList();

}
