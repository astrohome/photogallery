package org.galaxysoft.photogallery.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import java.util.Enumeration;
import java.util.ResourceBundle;

@Component(value = "msg")
public class ResourceBundleBean extends ResourceBundle {

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    protected Object handleGetObject(String key) {
        ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String message;
        try {
            message = messageSource.getMessage(key, null, request.getLocale());
        }
        catch (NoSuchMessageException e) {
            message = "???" + key + "???";
        }
        return message;
    }

    @Override
    public Enumeration<String> getKeys() {
        return null;
    }

}