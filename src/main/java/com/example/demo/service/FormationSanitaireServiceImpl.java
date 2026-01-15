
package com.example.demo.service;

import com.example.demo.dao.FormationSanitaireDao;
import com.example.demo.model.FormationSanitaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FormationSanitaireServiceImpl implements IFormationSanitaireService{


    @Autowired
   private FormationSanitaireDao formationSanitaireDaoRepo;


    @Override
    public Collection<FormationSanitaire> findAll() {
        Collection<FormationSanitaire> formationSanitaires= (Collection<FormationSanitaire>) formationSanitaireDaoRepo.findAll();
        return formationSanitaires;
    }

    @Override
    public Optional<FormationSanitaire> findOne(Long id) {
        Optional<FormationSanitaire> formationSanitaire = formationSanitaireDaoRepo.findById(id);
        return formationSanitaire;
    }

    @Override
    public FormationSanitaire create(FormationSanitaire formationSanitaire) {
        if(formationSanitaire.getId() != null){
            return null;

        }
        FormationSanitaire saveFormationSanitaire = formationSanitaireDaoRepo.save(formationSanitaire);
        return saveFormationSanitaire;
    }

    @Override
    public FormationSanitaire update(FormationSanitaire formationSanitaire) {
        Optional<FormationSanitaire> formationSanitairePersiste = findOne(formationSanitaire.getId());

        if(formationSanitairePersiste==null){
            return null;
        }
        FormationSanitaire updateFormationSanitaire=  formationSanitaireDaoRepo.save(formationSanitaire);
        return updateFormationSanitaire;
    }

    @Override
    public void delete(Long id) {
        formationSanitaireDaoRepo.deleteById(id);

    }
}

