package com.koou.common.factory;

import com.koou.common.model.JwtUser;
import com.koou.common.model.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-08 1:26 PM
 */
public class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static JwtUser create(UserInfo userInfo) {
        return new JwtUser(userInfo.getId(),
                userInfo.getUsername(),
                userInfo.getPassword(), mapToGrantedAuthorities(userInfo.getRoles()),
                userInfo.getLastPasswordResetDate());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }
}
