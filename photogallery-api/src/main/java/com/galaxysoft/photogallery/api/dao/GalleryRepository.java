package com.galaxysoft.photogallery.api.dao;

import com.galaxysoft.photogallery.api.model.Gallery;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Astrohome on 25.08.2015.
 */
public interface GalleryRepository extends CrudRepository<Gallery, Integer> {
}
