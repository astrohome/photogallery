package com.galaxysoft.photogallery.impl.model;

import com.galaxysoft.photogallery.api.model.Format;
import com.galaxysoft.photogallery.api.model.IdPK;
import com.galaxysoft.photogallery.api.model.PaperType;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public class IdPKImpl implements IdPK {

    private Format format;

    private PaperType paperType;

    public IdPKImpl(Format format, PaperType paperType) {
        this.format = format;
        this.paperType = paperType;
    }

    @Override
    public boolean equals(Object obj) {
        //check for self-comparison
        if (this == obj) return true;

        //use instanceof instead of getClass here for two reasons
        //1. if need be, it can match any supertype, and not just one class;
        //2. it renders an explict check for "that == null" redundant, since
        //it does the check for null already - "null instanceof [type]" always
        //returns false. (See Effective Java by Joshua Bloch.)

        if (!(obj instanceof IdPKImpl)) return false;
        //Alternative to the above line :
        //if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

        //cast to native object is now safe
        IdPKImpl that = (IdPKImpl) obj;

        return this.format.getId().equals(that.format.getId()) &&
                this.paperType.getId().equals(that.paperType.getId());
    }

    @Override
    public int hashCode() {
        return 37 * (this.getFormat().hashCode() + this.getPaperType().hashCode()) + 5;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(com.galaxysoft.photogallery.api.model.Format format) {
        this.format = format;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public void setPaperType(PaperType paperType) {
        this.paperType = paperType;
    }
}
