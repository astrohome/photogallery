package com.galaxysoft.photogallery.model.impl;

import com.galaxysoft.photogallery.model.IFormat;
import com.galaxysoft.photogallery.model.IIdPK;
import com.galaxysoft.photogallery.model.IPaperType;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Embeddable
public class IdPK implements IIdPK {
    @ManyToOne(optional = false)
    private IFormat format;

    @ManyToOne(optional = false)
    private IPaperType paperType;

    @Override
    public boolean equals(Object obj) {
        //check for self-comparison
        if (this == obj) return true;

        //use instanceof instead of getClass here for two reasons
        //1. if need be, it can match any supertype, and not just one class;
        //2. it renders an explict check for "that == null" redundant, since
        //it does the check for null already - "null instanceof [type]" always
        //returns false. (See Effective Java by Joshua Bloch.)

        if (!(obj instanceof IdPK)) return false;
        //Alternative to the above line :
        //if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

        //cast to native object is now safe
        IdPK that = (IdPK) obj;

        return this.format.getId().equals(that.format.getId()) &&
                this.paperType.getId().equals(that.paperType.getId());
    }

    public IdPK(IFormat format, IPaperType paperType) {
        this.format = format;
        this.paperType = paperType;
    }

    @Override
    public int hashCode() {
        return 37 * (this.getFormat().hashCode() + this.getPaperType().hashCode()) + 5;
    }

    public IFormat getFormat() {
        return format;
    }

    public void setFormat(IFormat format) {
        this.format = format;
    }

    public IPaperType getPaperType() {
        return paperType;
    }

    public void setPaperType(IPaperType paperType) {
        this.paperType = paperType;
    }
}
