package com.koou.controller;

import com.koou.common.controller.AbstractController;
import com.koou.common.dto.ResultDto;
import com.koou.common.dto.ResultDtoFactory;
import com.koou.domain.User;
import com.koou.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description: userController.
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-10 5:00 PM
 */
@RestController
@RequestMapping(value = "/users")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "创建用户", httpMethod = "POST", notes = "创建用户")
    public ResultDto<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResultDtoFactory.toACK("success");
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "查询用户", httpMethod = "GET", notes = "查询用户")
    public ResultDto<User> getUser(@PathVariable Long id) {
        return ResultDtoFactory.toACK("success", userService.getById(id));
    }

}
