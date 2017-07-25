package com.koou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koou.common.controller.AbstractController;
import com.koou.common.dto.ResultDto;
import com.koou.common.factory.ResultDtoFactory;
import com.koou.domain.User;
import com.koou.service.UserService;

import io.swagger.annotations.ApiOperation;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 5:00 PM
 */
@RestController
@RequestMapping(value = "/users")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;



    @GetMapping(value = "/{id}")
    @ApiOperation(value = "查询用户", httpMethod = "GET", notes = "查询用户")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResultDto<User> getUser(@PathVariable Long id) {

        return ResultDtoFactory.toACK("success", userService.getById(id));
    }

}
