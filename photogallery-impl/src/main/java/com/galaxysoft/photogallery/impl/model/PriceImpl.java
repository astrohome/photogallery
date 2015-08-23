package com.galaxysoft.photogallery.impl.model;

import com.galaxysoft.photogallery.api.model.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public class PriceImpl implements Price {

    private Format format;

    private PaperType paperType;

    private Float price;

    private Set<OrderItem> orderItems = new HashSet<>();

    @Override
    public String toString() {
        return this.format + " - " + this.paperType + " (" + this.price + " грн.)";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (this == obj) return true;

        if (!(obj instanceof PriceImpl)) return false;


        PriceImpl that = (PriceImpl) obj;
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

    public IdPK getId() {
        return new IdPKImpl(this.format, this.paperType);
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public void setPaperType(PaperType paperType) {
        this.paperType = paperType;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
