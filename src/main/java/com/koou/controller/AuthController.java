package com.koou.controller;

import javax.servlet.http.HttpServletRequest;

import com.koou.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koou.common.dto.ResultDto;
import com.koou.common.factory.ResultDtoFactory;
import com.koou.dto.request.LoginRequestDto;
import com.koou.service.AuthService;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-08 2:53 PM
 */
@RestController
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/auth")
    public ResultDto<String> createAuthenticationToken(@RequestBody LoginRequestDto loginRequestDto) {
        final String token = authService.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        return ResultDtoFactory.toACK(token);
    }

    @GetMapping(value = "/refresh")
    public ResultDto<String> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResultDtoFactory.toNACK(null);
        } else {
            return ResultDtoFactory.toACK(token);
        }
    }

    @PostMapping(value = "/auth/register")
    public void register(@RequestBody User addedUser) {
        authService.register(addedUser);
    }
}
