package com.galaxysoft.photogallery.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
public interface PaperType {
    @Id
    @GeneratedValue
    Integer getId();

    void setId(Integer id);

    @Column(nullable = false)
    @NotNull
    String getPaperType();

    void setPaperType(String paperType);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paperType", cascade = CascadeType.ALL)
    Set<Price> getPrice();

    void setPrice(Set<Price> price);
}
