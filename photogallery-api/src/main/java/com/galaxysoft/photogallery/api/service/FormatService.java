package com.galaxysoft.photogallery.api.service;

import com.galaxysoft.photogallery.api.model.Format;

/**
 * Created by Astrohome on 23.08.2015.
 */
public interface FormatService {
    Iterable<Format> findAll();
}
