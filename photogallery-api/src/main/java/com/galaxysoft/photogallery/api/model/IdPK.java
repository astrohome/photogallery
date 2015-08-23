package com.galaxysoft.photogallery.api.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Embeddable
public interface IdPK extends Serializable {
    @ManyToOne(optional = false)
    Format getFormat();

    void setFormat(Format format);

    @ManyToOne(optional = false)
    PaperType getPaperType();

    void setPaperType(PaperType paperType);
}
