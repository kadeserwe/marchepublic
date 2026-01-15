
package com.example.demo.dao;

import com.example.demo.model.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionsDao extends JpaRepository<Regions, Long> {
    public Optional<Regions> findById(Long id);



}

