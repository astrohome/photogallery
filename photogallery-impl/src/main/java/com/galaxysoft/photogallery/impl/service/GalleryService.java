package com.galaxysoft.photogallery.impl.service;

import com.galaxysoft.photogallery.api.dao.GalleryRepository;
import com.galaxysoft.photogallery.api.model.Gallery;
import com.galaxysoft.photogallery.api.service.IGalleryService;
import com.galaxysoft.photogallery.impl.service.base.BaseServiceImpl;
import com.galaxysoft.photogallery.utils.FileUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Astrohome on 21.08.2015.
 */
@Service
public class GalleryService extends BaseServiceImpl<Gallery> implements IGalleryService {

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public Set<Path> searchGalleries() {
        return fileUtils.searchGalleries();
    }

    @Override
    public List<Gallery> getAllGalleries() {
        return Lists.newArrayList(galleryRepository.findAll(new Sort(Sort.Direction.ASC, "created")));
    }

    @Override
    public List<Gallery> getPublicGalleries() {
        return Lists.newArrayList(galleryRepository.findByHiddenOrderByCreated(false));
    }

    @Override
    public List<Gallery> getByDate(Date created) {
        return Lists.newArrayList(galleryRepository.findByCreated(created));
    }

    @Override
    protected CrudRepository<Gallery, Integer> getDao() {
        return this.galleryRepository;
    }
}
