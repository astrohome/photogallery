package com.galaxysoft.photogallery.model.impl;

import com.galaxysoft.photogallery.model.IGallery;
import com.galaxysoft.photogallery.model.IOrderItem;
import com.galaxysoft.photogallery.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
public class Gallery implements IGallery {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column
    private String title;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column
    private Date created;

    @Transient
    private String createdText;

    @Column
    @NotNull
    private boolean hidden;

    @Column
    @NotNull
    private boolean watermark;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gallery", cascade = CascadeType.ALL)
    private Set<IOrderItem> orderItems = new HashSet<IOrderItem>();

    public Gallery(String title, Date created) {
        this.title = title;
        this.created = created;
        this.createdText = DateUtil.toTextString(this.created);
    }

    public String getEncodedTitle() throws UnsupportedEncodingException {
        return URLEncoder.encode(this.title, "UTF-8");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedText() {
        if (createdText == null || createdText.isEmpty()) {
            createdText = DateUtil.toTextString(created);
        }
        return createdText;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isWatermark() {
        return watermark;
    }

    public void setWatermark(boolean watermark) {
        this.watermark = watermark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<IOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<IOrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
