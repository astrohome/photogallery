package com.galaxysoft.photogallery.impl.service;

import com.galaxysoft.photogallery.api.service.GalleryService;
import com.galaxysoft.photogallery.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Set;

/**
 * Created by Astrohome on 21.08.2015.
 */
@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private FileUtils fileUtils;

    @Override
    public Set<Path> searchGalleries() {
        return fileUtils.searchGalleries();
    }
}
