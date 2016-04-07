package com.galaxysoft.photogallery.api.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Embeddable
public abstract class IdPK implements Serializable {
    @ManyToOne(optional = false)
    public abstract Format getFormat();

    public abstract void setFormat(Format format);

    @ManyToOne(optional = false)
    public abstract PaperType getPaperType();

    public abstract void setPaperType(PaperType paperType);

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
}
