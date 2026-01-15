package com.example.demo.dao;

import com.example.demo.model.Individu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividuDao extends JpaRepository<Individu, Long> {
    public Optional<Individu> findById(Long id);


}
