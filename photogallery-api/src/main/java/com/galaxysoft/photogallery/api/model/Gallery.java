package com.galaxysoft.photogallery.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
public interface Gallery {
    @Transient
    String getEncodedTitle() throws UnsupportedEncodingException;

    @Id
    @GeneratedValue
    Integer getId();

    void setId(Integer id);

    @NotNull
    @Column(nullable = false)
    String getTitle();

    void setTitle(String title);

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    @NotNull
    Date getCreated();

    void setCreated(Date created);

    @Transient
    String getCreatedText();

    @Column(nullable = false)
    @NotNull
    boolean isHidden();

    void setHidden(boolean hidden);

    @Column(nullable = false)
    @NotNull
    boolean isWatermark();

    void setWatermark(boolean watermark);

    @Column
    String getPassword();

    void setPassword(String password);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gallery", cascade = CascadeType.ALL)
    Set<OrderItem> getOrderItems();

    void setOrderItems(Set<OrderItem> orderItems);
}
