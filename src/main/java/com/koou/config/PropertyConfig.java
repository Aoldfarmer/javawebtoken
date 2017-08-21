package com.koou.config;

import org.springframework.core.env.Environment;

import com.koou.common.utils.AppContextUtils;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-29 5:03 PM
 */
public class PropertyConfig {

    private static Environment ev = AppContextUtils.getBean(Environment.class);


    public static class JwtConfig {
        public static final String CLAIM_KEY_USERNAME = "sub";
        public static final String CLAIM_KEY_CREATED = "created";

        public static final String SECRET = ev.getProperty("jwt.secret");
        public static final String TOKEN_HEAD = ev.getProperty("jwt.tokenHead");
        public static final String TOKEN_HEADER = ev.getProperty("jwt.header");
        public static final Long EXPIRATION = Long.parseLong(ev.getProperty("jwt.expiration"));
    }

}
