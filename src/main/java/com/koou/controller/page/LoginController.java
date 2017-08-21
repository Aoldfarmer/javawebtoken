package com.koou.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koou.common.controller.AbstractController;
import com.koou.common.dto.ResultDto;
import com.koou.common.factory.ResultDtoFactory;
import com.koou.dto.request.LoginRequestDto;
import com.koou.service.AuthService;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-08-21 1:04 PM
 */
@Controller
public class LoginController extends AbstractController {


    @Autowired
    private AuthService authService;


    @GetMapping(value = "/login")
    public String login() {
        return "index";
    }

    @PostMapping(value = "/index")
    @ResponseBody
    public ResultDto<String> createAuthenticationToken(@RequestBody LoginRequestDto loginRequestDto) {

        return ResultDtoFactory.toACK("success",
                authService.login(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
    }
}
