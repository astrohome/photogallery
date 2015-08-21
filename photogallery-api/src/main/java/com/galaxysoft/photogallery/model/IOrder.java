package com.galaxysoft.photogallery.model;

import java.util.Date;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IOrder extends IEntity {

    IUser getUser();

    void setUser(IUser user);

    Set<IOrderItem> getItems();

    void setItems(Set<IOrderItem> items);

    OrderStatus getStatus();

    void setStatus(OrderStatus status);

    float getSumm();

    Date getCreated();

    void setCreated(Date created);
}
