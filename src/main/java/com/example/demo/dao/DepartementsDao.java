
package com.example.demo.dao;

import com.example.demo.model.Communes;
import com.example.demo.model.Departements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartementsDao extends JpaRepository<Departements, Long> {
    public Optional<Departements> findById(Long id);

    public List<Departements> findDepartementByRegionId(Long departement);



}

