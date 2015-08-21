package com.galaxysoft.photogallery.model.impl;

import com.galaxysoft.photogallery.model.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
@IdClass(IdPK.class)
public class Price implements IPrice {

    @Id
    private IFormat format;
    @Id
    private IPaperType paperType;

    @Column
    @NotNull
    private Float price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "price", cascade = CascadeType.ALL)
    private Set<IOrderItem> orderItems = new HashSet<IOrderItem>();

    @Override
    public String toString() {
        return this.format + " - " + this.paperType + " (" + this.price + " грн.)";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (this == obj) return true;

        if (!(obj instanceof Price)) return false;


        Price that = (Price) obj;
        return !(that.format == null || that.paperType == null || this.format == null || this.paperType == null) && (this.format.equals(that.getFormat()) && this.paperType.equals(that.getPaperType()));

    }

    @Override
    public int hashCode() {
        return 37 * (this.format.hashCode() +
                this.paperType.hashCode() +
                Float.floatToIntBits(price)) + 5;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public IIdPK getId() {
        return new IdPK(this.format, this.paperType);
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

    public Set<IOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<IOrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
