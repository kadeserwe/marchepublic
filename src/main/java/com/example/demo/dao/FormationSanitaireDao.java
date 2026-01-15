
package com.example.demo.dao;
import com.example.demo.model.FormationSanitaire;
import com.example.demo.model.Individu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormationSanitaireDao extends JpaRepository<FormationSanitaire, Long> {
    public Optional<FormationSanitaire> findById(Long id);


}

