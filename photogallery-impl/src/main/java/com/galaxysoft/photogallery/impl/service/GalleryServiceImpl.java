package com.galaxysoft.photogallery.impl.service;

import com.galaxysoft.photogallery.api.dao.GalleryRepository;
import com.galaxysoft.photogallery.api.model.Gallery;
import com.galaxysoft.photogallery.api.service.GalleryService;
import com.galaxysoft.photogallery.impl.service.base.BaseServiceImpl;
import com.galaxysoft.photogallery.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Set;

/**
 * Created by Astrohome on 21.08.2015.
 */
@Service
public class GalleryServiceImpl extends BaseServiceImpl<Gallery> implements GalleryService {

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public Set<Path> searchGalleries() {
        return fileUtils.searchGalleries();
    }

    @Override
    protected CrudRepository<Gallery, Integer> getDao() {
        return this.galleryRepository;
    }
}
