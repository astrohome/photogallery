package com.galaxysoft.photogallery.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public class DispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null /*{ SpringRootConfig.class }*/;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}