package com.koou.common.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.koou.common.utils.AppContextUtil;
import com.koou.common.utils.JwtTokenUtil;
import com.koou.config.PropertyConfig;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-07 8:04 PM
 */
@Slf4j
public class JwtAuthenticationFilter implements Filter {

    private static UserDetailsService userDetailsService = AppContextUtil.getBean(UserDetailsService.class);
    private static JwtTokenUtil jwtTokenUtil = AppContextUtil.getBean(JwtTokenUtil.class);


    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authHeader = request.getHeader(PropertyConfig.JwtConfig.TOKEN_HEADER);
        log.info("Token Header: " + PropertyConfig.JwtConfig.TOKEN_HEADER);

        if (authHeader != null && authHeader.startsWith(PropertyConfig.JwtConfig.TOKEN_HEAD)) {

            final String authToken = authHeader.substring(PropertyConfig.JwtConfig.TOKEN_HEAD.length());
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            log.info("checking authentication " + username);
            if (username != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtTokenUtil.validateToken(authToken, userDetails)) {

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    log.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    chain.doFilter(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                }
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }

}
