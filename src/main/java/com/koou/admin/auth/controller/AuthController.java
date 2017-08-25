package com.koou.admin.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.koou.admin.auth.dto.request.LoginRequestDto;
import com.koou.admin.auth.dto.request.RegisterRequestDto;
import com.koou.admin.auth.dto.response.LoginResponseDto;
import com.koou.admin.base.service.AuthService;
import com.koou.common.config.PropertyConfig;
import com.koou.common.domain.User;
import com.koou.common.dto.ResultDto;
import com.koou.common.factory.ResultDtoFactory;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-08 2:53 PM
 */
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/auth")
    public ResultDto<LoginResponseDto> createAuthenticationToken(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            final String token = authService.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());
            return ResultDtoFactory.toACK("success",
                    new LoginResponseDto(loginRequestDto.getUsername(), token));
        } catch (Exception e) {
            return ResultDtoFactory.toNACK("认证失败");
        }
    }

    @GetMapping(value = "/refresh")
    public ResultDto<String> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(PropertyConfig.JwtConfig.TOKEN_HEADER);
        String refreshedToken = authService.refresh(token);
        if (StringUtils.isEmpty(refreshedToken)) {
            return ResultDtoFactory.toNACK(null);
        } else {
            return ResultDtoFactory.toACK("success",
                    refreshedToken.substring(PropertyConfig.JwtConfig.TOKEN_HEAD.length()));
        }
    }

    @PostMapping(value = "/auth/register")
    public ResultDto<User> register(@RequestBody RegisterRequestDto registerRequestDto) {
        String username = registerRequestDto.getUsername();
        String password = registerRequestDto.getPassword();
        return ResultDtoFactory.toACK("success", authService.register(username, password));
    }
}
