package com.galaxysoft.photogallery.api.dao;

import com.galaxysoft.photogallery.api.model.Gallery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

/**
 * Created by Astrohome on 25.08.2015.
 */
public interface GalleryRepository extends PagingAndSortingRepository<Gallery, Integer> {
    Iterable<Gallery> findByCreated(Date created);

    Iterable<Gallery> findByHiddenOrderByCreated(boolean hidden);
}
