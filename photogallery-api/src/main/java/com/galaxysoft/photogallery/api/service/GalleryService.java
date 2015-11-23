package com.galaxysoft.photogallery.api.service;

import com.galaxysoft.photogallery.api.model.Gallery;
import com.galaxysoft.photogallery.api.service.base.BaseService;

import java.nio.file.Path;
import java.util.Set;

/**
 * Created by Astrohome on 21.08.2015.
 */
public interface GalleryService extends BaseService<Gallery> {
    /**
     * Searches for all folders containing specified extension of file
     *
     * @return the set of all found galleries.
     */
    Set<Path> searchGalleries();
}
