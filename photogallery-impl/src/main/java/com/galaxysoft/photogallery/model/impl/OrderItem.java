package com.galaxysoft.photogallery.model.impl;

import com.galaxysoft.photogallery.model.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
public class OrderItem implements IOrderItem {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @NotNull
    private String image;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "gallery_id")
    private IGallery gallery;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id")
    private IUser IUser;

    @ManyToOne
    @NotNull
    @JoinColumns({
            @JoinColumn(name = "format_id"),
            @JoinColumn(name = "paperType_id")
    })
    private IPrice price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private IOrder order;

    @Column
    @NotNull
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(String image, IGallery gallery, Price price, Integer quantity, IUser IUser) {
        this.image = image;
        this.gallery = gallery;
        this.quantity = quantity;
        this.price = price;
        this.IUser = IUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public IGallery getGallery() {
        return gallery;
    }

    public void setGallery(IGallery gallery) {
        this.gallery = gallery;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public IOrder getOrder() {
        return order;
    }

    public void setOrder(IOrder order) {
        this.order = order;
    }

    public IPrice getPrice() {
        return price;
    }

    public void setPrice(IPrice price) {
        this.price = price;
    }

    public IUser getUser() {
        return IUser;
    }

    public void setUser(IUser IUser) {
        this.IUser = IUser;
    }
}
