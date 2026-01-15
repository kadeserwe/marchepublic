
package com.example.demo.dao;

import com.example.demo.model.Clients;
import com.example.demo.model.Communes;
import com.example.demo.model.Produits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProduitsDao extends JpaRepository<Produits, Long> {
    public Optional<Produits> findById(Long id);
    public List<Produits> findByFournisseurId(Long fournisseur);



}

