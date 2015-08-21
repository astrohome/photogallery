package com.galaxysoft.photogallery.model.impl;

import com.galaxysoft.photogallery.model.IOrder;
import com.galaxysoft.photogallery.model.IOrderItem;
import com.galaxysoft.photogallery.model.IUser;
import com.galaxysoft.photogallery.model.OrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table(name = "Order_")
public class Order implements IOrder {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private IUser IUser;

    @Column
    @NotNull
    private OrderStatus status;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column
    private Date created;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private Set<IOrderItem> items = new HashSet<IOrderItem>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IUser getUser() {
        return IUser;
    }

    public void setUser(IUser IUser) {
        this.IUser = IUser;
    }

    public Set<IOrderItem> getItems() {
        return items;
    }

    public void setItems(Set<IOrderItem> items) {
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
        for (IOrderItem item : items) {
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
