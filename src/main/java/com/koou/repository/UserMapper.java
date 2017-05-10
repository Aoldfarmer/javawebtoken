package com.koou.repository;

import com.koou.dto.response.UserListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description: user操作数据库类.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 4:56 PM
 */
@Mapper
public interface UserMapper {

    List<UserListResponseDto> queryUserList();

}
