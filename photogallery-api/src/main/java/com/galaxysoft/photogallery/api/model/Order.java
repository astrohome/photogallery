package com.galaxysoft.photogallery.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table(name = "Order_")
public interface Order {

    @Id
    @GeneratedValue
    Integer getId();

    void setId(Integer id);

    @ManyToOne
    @JoinColumn(name = "user_id")
    User getUser();

    void setUser(User user);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    Set<OrderItem> getItems();

    void setItems(Set<OrderItem> items);

    @Column(nullable = false)
    @NotNull
    OrderStatus getStatus();

    void setStatus(OrderStatus status);

    @Transient
    float getSumm();

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    @Column(nullable = false)
    Date getCreated();

    void setCreated(Date created);
}
