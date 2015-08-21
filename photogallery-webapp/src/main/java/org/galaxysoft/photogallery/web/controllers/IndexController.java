package org.galaxysoft.photogallery.web.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Illia IZOTOV on 21/08/15.
 */
@ManagedBean(name = "index")
@SessionScoped
public class IndexController {
    public void init() {
        System.out.println("init");
    }

    public String getHelloWorld() {
        return "Hello big big world!";
    }
}
