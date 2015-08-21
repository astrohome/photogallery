package com.galaxysoft.photogallery.model;

import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IFormat extends IEntity {

    String getFormat();

    void setFormat(String format);

    Set<IPrice> getPrice();

    void setPrice(Set<IPrice> price);
}
