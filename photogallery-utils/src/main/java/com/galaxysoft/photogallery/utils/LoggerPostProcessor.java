package com.galaxysoft.photogallery.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * LoggerPostProcessor => Custom Spring BeanPostProcessor *
 */
@Component
public class LoggerPostProcessor implements BeanPostProcessor {

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), field -> {
            if (field.getAnnotation(Log.class) != null) {
                ReflectionUtils.makeAccessible(field);
                Logger log = LogManager.getLogger(bean.getClass());
                field.set(bean, log);
            }
        });
        return bean;
    }
}