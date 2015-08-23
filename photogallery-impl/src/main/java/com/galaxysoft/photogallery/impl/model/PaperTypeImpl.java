package com.galaxysoft.photogallery.impl.model;

import com.galaxysoft.photogallery.api.model.PaperType;
import com.galaxysoft.photogallery.api.model.Price;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public class PaperTypeImpl implements PaperType {

    private Integer id;

    private String paperType;

    private Set<Price> price = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        //check for self-comparison
        if (this == obj) return true;

        if (!(obj instanceof PaperTypeImpl)) return false;

        PaperTypeImpl that = (PaperTypeImpl) obj;

        return !(that.id == null || this.id == null) && this.id.equals(that.id);
    }

    @Override
    public String toString() {
        return this.paperType;
    }

    @Override
    public int hashCode() {
        return 37 * ((this.id != null) ? this.id : 1 + this.paperType.hashCode()) + 5;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public Set<Price> getPrice() {
        return price;
    }

    public void setPrice(Set<Price> price) {
        this.price = price;
    }
}
