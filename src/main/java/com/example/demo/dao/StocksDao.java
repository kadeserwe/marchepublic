
package com.example.demo.dao;

import com.example.demo.model.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StocksDao extends JpaRepository<Stocks, Long> {
    public Optional<Stocks> findById(Long id);



}

