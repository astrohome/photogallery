package com.galaxysoft.photogallery.impl.model;

import com.galaxysoft.photogallery.api.model.Format;
import com.galaxysoft.photogallery.api.model.Price;
import com.galaxysoft.photogallery.impl.model.base.BaseImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public class FormatImpl extends BaseImpl implements Format {

    private String format;

    private Set<Price> price = new HashSet<>();

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object obj) {
        //check for self-comparison
        if (this == obj) return true;

        if (!(obj instanceof Format)) return false;

        Format that = (Format) obj;

        return !(that.getId() == null || this.id == null) && this.id.equals(that.getId());
    }

    @Override
    public String toString() {
        return this.format;
    }

    @Override
    public int hashCode() {
        return 37 * ((this.id != null) ? this.id : 1 + this.format.hashCode()) + 5;
    }

    public Set<Price> getPrice() {
        return price;
    }

    public void setPrice(Set<Price> price) {
        this.price = price;
    }
}
