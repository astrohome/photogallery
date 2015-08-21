package com.galaxysoft.photogallery.model;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IIdPK {
    IFormat getFormat();

    void setFormat(IFormat format);

    IPaperType getPaperType();

    void setPaperType(IPaperType paperType);
}
