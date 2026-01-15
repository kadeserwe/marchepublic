
package com.example.demo.dao;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Transactional
public interface OrderItemDao extends JpaRepository<OrderItem, Long> {
    public Optional<OrderItem> findById(Long id);
   // Order findByOrderTrackingNumber(String orderTrackingNumber);


}

