package com.galaxysoft.photogallery.impl.service;

import com.galaxysoft.photogallery.api.dao.OrderRepository;
import com.galaxysoft.photogallery.api.model.Order;
import com.galaxysoft.photogallery.api.service.OrderService;
import com.galaxysoft.photogallery.impl.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Astrohome on 25.08.2015.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    protected CrudRepository<Order, Integer> getDao() {
        return this.orderRepository;
    }
}
