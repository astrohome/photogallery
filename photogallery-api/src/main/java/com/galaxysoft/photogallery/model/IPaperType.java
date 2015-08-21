package com.galaxysoft.photogallery.model;

import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IPaperType extends IEntity {

    String getPaperType();

    void setPaperType(String paperType);

    Set<IPrice> getPrice();

    void setPrice(Set<IPrice> price);
}
