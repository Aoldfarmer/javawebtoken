package com.koou.admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-29 4:45 PM
 */
@Component
public class AppContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T getBean(final Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        AppContext.applicationContext = applicationContext;
    }

}
