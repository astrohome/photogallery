package com.galaxysoft.photogallery.impl.model;

import com.galaxysoft.photogallery.api.model.Gallery;
import com.galaxysoft.photogallery.api.model.OrderItem;
import com.galaxysoft.photogallery.utils.DateUtil;

import java.beans.Transient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */

public class GalleryImpl implements Gallery {

    private Integer id;

    private String title;

    private Date created;

    private String createdText;

    private boolean hidden;

    private boolean watermark;

    private String password;

    private Set<OrderItem> orderItems = new HashSet<>();

    public GalleryImpl(String title, Date created) {
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

    @Transient
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

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
