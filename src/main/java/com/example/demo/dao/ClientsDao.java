
package com.example.demo.dao;

import com.example.demo.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientsDao extends JpaRepository<Clients, Long> {
    public Optional<Clients> findById(Long id);


}

