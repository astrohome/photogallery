package com.galaxysoft.photogallery.impl.model;

import com.galaxysoft.photogallery.api.model.*;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public class OrderItemImpl implements OrderItem {

    private Integer id;

    private String image;

    private Gallery gallery;

    private User user;

    private Price price;

    private Order order;

    private Integer quantity;

    public OrderItemImpl() {
    }

    public OrderItemImpl(String image, Gallery gallery, PriceImpl priceImpl, Integer quantity, User user) {
        this.image = image;
        this.gallery = gallery;
        this.quantity = quantity;
        this.price = priceImpl;
        this.user = user;
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

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User User) {
        this.user = User;
    }
}
