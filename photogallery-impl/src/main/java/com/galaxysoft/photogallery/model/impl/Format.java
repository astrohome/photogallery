package com.galaxysoft.photogallery.model.impl;

import com.galaxysoft.photogallery.model.IFormat;
import com.galaxysoft.photogallery.model.IPrice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
public class Format implements IFormat {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @NotNull
    private String format;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "format", cascade = CascadeType.ALL)
    private Set<IPrice> price = new HashSet<IPrice>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

        return !(that.id == null || this.id == null) && this.id.equals(that.id);
    }

    @Override
    public String toString() {
        return this.format;
    }

    @Override
    public int hashCode() {
        return 37 * ((this.id != null) ? this.id : 1 + this.format.hashCode()) + 5;
    }

    public Set<IPrice> getPrice() {
        return price;
    }

    public void setPrice(Set<IPrice> price) {
        this.price = price;
    }
}
