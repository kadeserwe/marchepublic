

package com.example.demo.service;

import com.example.demo.dao.OrderItemDao;
import com.example.demo.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements IOrderItemService{


    @Autowired
   private OrderItemDao orderItmDaoRepo;


    @Override
    public Collection<OrderItem> findAll() {
        Collection<OrderItem> orderItms= (Collection<OrderItem>) orderItmDaoRepo.findAll();
        return orderItms;
    }

    @Override
    public Optional<OrderItem> findOne(Long id) {
        Optional<OrderItem>orderItm = orderItmDaoRepo.findById(id);
        return orderItm;
    }

    @Override
    public OrderItem create(OrderItem orderItm) {
        if(orderItm.getId() != null){
            return null;

        }
        OrderItem saveOrderItm= orderItmDaoRepo.save(orderItm);
        return saveOrderItm;
    }

    @Override
    public OrderItem update(OrderItem orderItm) {
        Optional<OrderItem> orderItmPersiste = findOne(orderItm.getId());

        if(orderItmPersiste==null){
            return null;
        }
        OrderItem updateOrderItm=  orderItmDaoRepo.save(orderItm);
        return updateOrderItm;
    }

    @Override
    public void delete(Long id) {
        orderItmDaoRepo.deleteById(id);

    }
}


