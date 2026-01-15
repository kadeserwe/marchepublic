
package com.example.demo.service;

import com.example.demo.model.FormationSanitaire;

import java.util.Collection;
import java.util.Optional;

public interface IFormationSanitaireService {
   public Collection<FormationSanitaire> findAll();
    Optional<FormationSanitaire> findOne (Long id);
    FormationSanitaire create (FormationSanitaire formationSanitaire);
    FormationSanitaire update (FormationSanitaire formationSanitaire);
    void delete (Long id);

}

