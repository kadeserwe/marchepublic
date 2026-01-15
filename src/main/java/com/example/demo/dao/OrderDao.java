
package com.example.demo.dao;
import com.example.demo.model.Categories;
import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Transactional
public interface OrderDao extends JpaRepository<Order, Long> {
    public Optional<Order> findById(Long id);
    Order findByOrderTrackingNumber(String orderTrackingNumber);


}

