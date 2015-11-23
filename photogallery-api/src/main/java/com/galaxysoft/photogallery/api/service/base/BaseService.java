package com.galaxysoft.photogallery.api.service.base;

/**
 * Created by Astrohome on 25.08.2015.
 */
public interface BaseService<T> {
    Iterable<T> getAll();

    long count();

    T save(T item);

    Iterable<T> save(Iterable<T> items);
}
