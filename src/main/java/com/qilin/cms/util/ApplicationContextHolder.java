package com.qilin.cms.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHolder implements ApplicationContextAware {

    private static final Log log = LogFactory.getLog(ApplicationContextHolder.class);

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(Class<T> var1) throws BeansException {
        return context.getBean(var1);
    }

//    public static <T> T getBean(Class<T> var1, Object... var2) throws BeansException {
//        return context.getBean(var1, var2);
//    }

    public static <T> T getAutoBean(Class<T> var1) throws BeansException {
        return autowireBean(context.getBean(var1));
    }

//    public static <T> T getAutoBean(Class<T> var1, Object... var2) throws BeansException {
//        return autowireBean(context.getBean(var1,var2));
//    }


    public static <T> T autowireBean(T var1) throws BeansException {;
        getContext().getAutowireCapableBeanFactory().autowireBean(var1);
        return var1;
    }

}