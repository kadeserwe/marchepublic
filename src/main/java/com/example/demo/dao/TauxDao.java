
package com.example.demo.dao;
import com.example.demo.model.Taux;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Transactional
public interface TauxDao extends JpaRepository<Taux, Long> {
    public Optional<Taux> findById(Long id);


}

