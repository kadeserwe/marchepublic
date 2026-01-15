
package com.example.demo.service;

import com.example.demo.model.OrderItem;

import java.util.Collection;
import java.util.Optional;

public interface IOrderItemService {
    public Collection<OrderItem> findAll();
    Optional<OrderItem> findOne (Long id);
    OrderItem create (OrderItem order);
    OrderItem update (OrderItem order);
    void delete (Long id);

}


