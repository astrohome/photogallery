package com.galaxysoft.photogallery.web.controllers;

import com.galaxysoft.photogallery.api.service.GalleryService;
import com.galaxysoft.photogallery.utils.Log;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Astrohome on 21.08.2015.
 */
@Controller
public class IndexController {

    @Autowired
    private GalleryService galleryService;

    @Log
    private Logger logger;

    private void constructPublicMenu(Map<String, Object> modelAndView) {
        LinkedHashMap<String, String> menu = new LinkedHashMap<>();
        menu.put("/", "page.menu.public.index");
        menu.put("/private", "page.menu.public.code");
        menu.put("/videos", "page.menu.public.video");
        modelAndView.put("menuItems", menu);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        constructPublicMenu(model);
        model.put("galleries", galleryService.searchGalleries());
        return "index";
    }

}