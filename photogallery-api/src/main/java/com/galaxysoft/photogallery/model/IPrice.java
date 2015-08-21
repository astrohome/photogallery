package com.galaxysoft.photogallery.model;

import java.io.Serializable;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IPrice extends Serializable {
    Float getPrice();

    IIdPK getId();

    void setPrice(Float price);

    IFormat getFormat();

    void setFormat(IFormat format);

    IPaperType getPaperType();

    void setPaperType(IPaperType paperType);
}
