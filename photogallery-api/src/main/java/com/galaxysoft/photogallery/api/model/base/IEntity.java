package com.galaxysoft.photogallery.api.model.base;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public interface IEntity extends Serializable {

    @Id
    @Column(unique = true)
    @GeneratedValue
    @Transient
    Integer getId();

    @Transient
    void setId(Integer id);
}
