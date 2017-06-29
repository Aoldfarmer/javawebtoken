package com.koou.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.koou.common.filter.JwtAuthenticationFilter;
import com.koou.common.security.JwtAuthenticationEntryPoint;

/**
 * @author koou
 * @version 1.0
 * @since 2017-05-11 下午 22:49
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private String[] ignoreSwagger = {"/", "/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
            "/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui", "/swagger-resources/configuration/security"};


    private String[] ignoreAuthPath = {"/auth", "/auth/**"};

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                    .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);



        http.authorizeRequests()
                .anyRequest().authenticated();


        http.headers().cacheControl();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        
        web.ignoring().antMatchers(ignoreSwagger).antMatchers(ignoreAuthPath);
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
