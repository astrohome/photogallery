package com.galaxysoft.photogallery.impl.model.base;

import com.galaxysoft.photogallery.api.model.base.IEntity;

/**
 * Created by Astrohome on 23.08.2015.
 */
public abstract class BaseImpl implements IEntity {

    protected Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
