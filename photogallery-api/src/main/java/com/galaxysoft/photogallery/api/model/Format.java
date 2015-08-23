package com.galaxysoft.photogallery.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table
public interface Format {

    @Id
    @Column(unique = true)
    @GeneratedValue
    Integer getId();

    void setId(Integer id);

    @Column(nullable = false)
    @NotNull
    String getFormat();

    void setFormat(String format);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "format", cascade = CascadeType.ALL)
    Set<Price> getPrice();

    void setPrice(Set<Price> price);
}
