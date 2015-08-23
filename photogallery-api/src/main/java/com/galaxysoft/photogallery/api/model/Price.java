package com.galaxysoft.photogallery.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
@IdClass(IdPK.class)
public interface Price extends Serializable {
    @Column(nullable = false)
    @NotNull
    Float getPrice();

    void setPrice(Float price);

    @Transient
    IdPK getId();

    @Id
    Format getFormat();

    void setFormat(Format format);

    @Id
    PaperType getPaperType();

    void setPaperType(PaperType paperType);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "price", cascade = CascadeType.ALL)
    Set<OrderItem> getOrderItems();

    void setOrderItems(Set<OrderItem> items);
}
