package com.jiangwei.mybatistablescale.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC:
 */

public class ContextHelper implements ApplicationContextAware {

    static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = applicationContext;
    }

    public static  <T>T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
