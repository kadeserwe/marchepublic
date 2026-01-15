

package com.example.demo.dao;

import com.example.demo.model.Individu;
import com.example.demo.model.Jugement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JugementDao extends JpaRepository<Jugement, Long> {
    public Optional<Jugement> findById(Long id);


}


