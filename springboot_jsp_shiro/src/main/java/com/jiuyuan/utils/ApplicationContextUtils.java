package com.jiuyuan.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author shkstart
 * @create 2021-07-29 18:58
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware{
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName){
        System.out.println("----------------beanNmae: "+beanName);
        Object bean = applicationContext.getBean(beanName);
        System.out.println("-------------------bean: "+bean);
        return bean;
    }
}
