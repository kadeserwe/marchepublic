
package com.example.demo.dao;

import com.example.demo.model.Clients;
import com.example.demo.model.Commandes;
import com.example.demo.model.Produits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandesDao extends JpaRepository<Commandes, Long> {
    public Optional<Commandes> findById(Long id);
    public List<Commandes> findByClientId(Long client);


}

