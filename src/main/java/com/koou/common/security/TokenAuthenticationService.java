package com.koou.common.security;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-07 8:10 PM
 */
@Slf4j
public class TokenAuthenticationService {

    static final long EXPIRATION_TIME = 432000000;
    static final String SECRET = "P@ssw02d";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletResponse response, String username) {
        String JWT = Jwts.builder()
                .claim("authorities", "ROLE_ADMIN,AUTH_WRITE")
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        try {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().println(JWT);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String username = claims.getSubject();
            List<GrantedAuthority> authorities = null;
            return username != null ?
                    new UsernamePasswordAuthenticationToken(username, null, authorities)
                    : null;
        }
        return null;
    }

}
