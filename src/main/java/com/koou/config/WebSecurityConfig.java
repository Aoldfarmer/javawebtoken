package com.koou.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author koou
 * @version 1.0
 * @since 2017-05-11 下午 22:49
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private String[] ignoreSwagger = {"/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
            "/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui", "/swagger-resources/configuration/security"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(ignoreSwagger).permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/index")
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("yunqiangdi")
                .password("di2chen@2017")
                .roles("USER");
    }

}
