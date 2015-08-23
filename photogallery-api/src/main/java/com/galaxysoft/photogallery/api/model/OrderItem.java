package com.galaxysoft.photogallery.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
public interface OrderItem {
    @Id
    @GeneratedValue
    Integer getId();

    void setId(Integer id);

    @Column(nullable = false)
    @NotNull
    String getImage();

    void setImage(String image);

    @ManyToOne
    @NotNull
    @JoinColumn(name = "gallery_id")
    Gallery getGallery();

    void setGallery(Gallery gallery);

    @NotNull
    @Column(nullable = false)
    Integer getQuantity();

    void setQuantity(Integer quantity);

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order getOrder();

    void setOrder(Order order);

    @ManyToOne
    @NotNull
    @JoinColumns({
            @JoinColumn(name = "format_id"),
            @JoinColumn(name = "paperType_id")
    })
    Price getPrice();

    void setPrice(Price price);

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id")
    User getUser();

    void setUser(User user);
}
