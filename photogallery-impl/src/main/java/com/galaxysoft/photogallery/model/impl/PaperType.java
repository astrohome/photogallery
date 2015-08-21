package com.galaxysoft.photogallery.model.impl;

import com.galaxysoft.photogallery.model.IPaperType;
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
public class PaperType implements IPaperType {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    @NotNull
    private String paperType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paperType", cascade = CascadeType.ALL)
    private Set<IPrice> price = new HashSet<IPrice>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        //check for self-comparison
        if (this == obj) return true;

        if (!(obj instanceof PaperType)) return false;

        PaperType that = (PaperType) obj;

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

    public Set<IPrice> getPrice() {
        return price;
    }

    public void setPrice(Set<IPrice> price) {
        this.price = price;
    }
}
