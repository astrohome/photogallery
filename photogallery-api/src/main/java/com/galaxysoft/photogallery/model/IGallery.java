package com.galaxysoft.photogallery.model;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IGallery {
    String getEncodedTitle() throws UnsupportedEncodingException;

    Integer getId();

    void setId(Integer id);

    String getTitle();

    void setTitle(String title);

    Date getCreated();

    void setCreated(Date created);

    String getCreatedText();

    boolean isHidden();

    void setHidden(boolean hidden);

    boolean isWatermark();

    void setWatermark(boolean watermark);

    String getPassword();

    void setPassword(String password);

    Set<IOrderItem> getOrderItems();

    void setOrderItems(Set<IOrderItem> orderItems);
}
