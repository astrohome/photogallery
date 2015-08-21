package com.galaxysoft.photogallery.model;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IOrderItem extends IEntity {

    String getImage();

    void setImage(String image);

    IGallery getGallery();

    void setGallery(IGallery gallery);

    Integer getQuantity();

    void setQuantity(Integer quantity);

    IOrder getOrder();

    void setOrder(IOrder order);

    IPrice getPrice();

    void setPrice(IPrice price);

    IUser getUser();

    void setUser(IUser user);
}
