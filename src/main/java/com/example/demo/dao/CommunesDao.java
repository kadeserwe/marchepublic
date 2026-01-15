
package com.example.demo.dao;

import com.example.demo.model.Communes;
import com.example.demo.model.Naissance;
import com.example.demo.model.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommunesDao extends JpaRepository<Communes, Long> {
    public Optional<Communes> findById(Long id);
    public List<Communes> findByDepartementId(Long departement);



}

