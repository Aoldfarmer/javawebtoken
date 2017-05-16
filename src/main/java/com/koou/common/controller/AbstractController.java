package com.koou.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author koou
 * @version 1.0
 * @since 2017-05-12 上午 9:49
 */

public abstract class AbstractController {

    protected Logger log = LoggerFactory.getLogger(getClass());

    public String currentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
