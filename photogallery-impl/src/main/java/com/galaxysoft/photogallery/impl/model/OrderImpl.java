package com.galaxysoft.photogallery.impl.model;

import com.galaxysoft.photogallery.api.model.Order;
import com.galaxysoft.photogallery.api.model.OrderItem;
import com.galaxysoft.photogallery.api.model.OrderStatus;
import com.galaxysoft.photogallery.api.model.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public class OrderImpl implements Order {

    private Integer id;

    private User User;

    private OrderStatus status;

    private Date created;

    private Set<OrderItem> items = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public float getSumm() {
        float res = 0;
        for (OrderItem item : items) {
            res += item.getPrice().getPrice();
        }
        return res;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
