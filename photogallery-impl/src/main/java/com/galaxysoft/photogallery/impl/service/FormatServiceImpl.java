package com.galaxysoft.photogallery.impl.service;

import com.galaxysoft.photogallery.api.dao.FormatRepository;
import com.galaxysoft.photogallery.api.model.Format;
import com.galaxysoft.photogallery.api.service.FormatService;
import com.galaxysoft.photogallery.impl.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Astrohome on 23.08.2015.
 */
@Service
public class FormatServiceImpl extends BaseServiceImpl<Format> implements FormatService {
    @Autowired
    private FormatRepository formatRepository;

    @Override
    protected CrudRepository<Format, Integer> getDao() {
        return formatRepository;
    }
}
