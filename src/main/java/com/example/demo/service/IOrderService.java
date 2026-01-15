
package com.example.demo.service;

import com.example.demo.model.Clients;
import com.example.demo.model.Order;

import java.util.Collection;
import java.util.Optional;

public interface IOrderService {
    public Collection<Order> findAll();
    Optional<Order> findOne (Long id);
    Order create (Order order);
    Order update (Order order);
    void delete (Long id);

}


