package com.koou.controller;

import com.koou.dto.response.UserListResponseDto;
import com.koou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: userController.
 *
 * @author yunqiangdi
 * @version 1.0
 * @date 2017-05-10 5:00 PM
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserListResponseDto> getUsers() {
        return userService.queryUserList();
    }

}
