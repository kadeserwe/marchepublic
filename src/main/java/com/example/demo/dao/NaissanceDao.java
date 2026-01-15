

package com.example.demo.dao;

import com.example.demo.model.Jugement;
import com.example.demo.model.Naissance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NaissanceDao extends JpaRepository<Naissance, Long> {
    public Optional<Naissance> findById(Long id);
    public List<Naissance> findBynumeroActe(Integer numeroActe);


}


