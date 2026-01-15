

package com.example.demo.service;

import com.example.demo.dao.ClientsDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.model.Clients;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService{


    @Autowired
   private OrderDao orderDaoRepo;


    @Override
    public Collection<Order> findAll() {
        Collection<Order> orders= (Collection<Order>) orderDaoRepo.findAll();
        return orders;
    }

    @Override
    public Optional<Order> findOne(Long id) {
        Optional<Order> order = orderDaoRepo.findById(id);
        return order;
    }

    @Override
    public Order create(Order order) {
        if(order.getId() != null){
            return null;

        }
        Order saveorder= orderDaoRepo.save(order);
        return saveorder;
    }

    @Override
    public Order update(Order order) {
        Optional<Order> orderPersiste = findOne(order.getId());

        if(orderPersiste==null){
            return null;
        }
        Order updateorder=  orderDaoRepo.save(order);
        return updateorder;
    }

    @Override
    public void delete(Long id) {
        orderDaoRepo.deleteById(id);

    }
}


