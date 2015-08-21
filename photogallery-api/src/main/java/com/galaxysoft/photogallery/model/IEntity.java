package com.galaxysoft.photogallery.model;

import java.io.Serializable;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IEntity extends Serializable {
    Integer getId();

    void setId(Integer id);
}
