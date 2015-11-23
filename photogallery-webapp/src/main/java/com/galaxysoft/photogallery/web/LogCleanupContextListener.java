package com.galaxysoft.photogallery.web;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by astrohome on 11/23/15.
 */
public class LogCleanupContextListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("LogCleanupContextListener::contextDestroyed");
        // Code repris de la documentation de logback :
        //  http://logback.qos.ch/manual/jmxConfig.html
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        lc.stop();
    }

    public void contextInitialized(ServletContextEvent sce) {
    }
}
