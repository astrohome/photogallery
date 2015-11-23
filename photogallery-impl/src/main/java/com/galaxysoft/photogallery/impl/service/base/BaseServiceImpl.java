package com.galaxysoft.photogallery.impl.service.base;

import com.galaxysoft.photogallery.api.service.base.BaseService;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Astrohome on 25.08.2015.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected abstract CrudRepository<T, Integer> getDao();

    @Override
    public Iterable<T> getAll() {
        return getDao().findAll();
    }

    @Override
    public long count() {
        return getDao().count();
    }

    @Override
    public T save(T item) {
        return getDao().save(item);
    }

    @Override
    public Iterable<T> save(Iterable<T> items) {
        return getDao().save(items);
    }
}
