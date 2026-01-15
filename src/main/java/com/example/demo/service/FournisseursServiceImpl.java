

package com.example.demo.service;

import com.example.demo.dao.CategoriesDao;
import com.example.demo.dao.FournisseursDao;
import com.example.demo.model.Categories;
import com.example.demo.model.Fournisseurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FournisseursServiceImpl implements IFournisseursService{


    @Autowired
   private FournisseursDao fournisseurDaoRepo;


    @Override
    public Collection<Fournisseurs> findAll() {
        Collection<Fournisseurs> fournisseurs= (Collection<Fournisseurs>) fournisseurDaoRepo.findAll();
        return fournisseurs;
    }



    @Override
    public Optional<Fournisseurs> findOne(Long id) {
        Optional<Fournisseurs> fournisseur = fournisseurDaoRepo.findById(id);
        return fournisseur;
    }

    @Override
    public Fournisseurs create(Fournisseurs fournisseur) {
        if(fournisseur.getId() != null){
            return null;

        }
        Fournisseurs saveFournisseur= fournisseurDaoRepo.save(fournisseur);
        return saveFournisseur;
    }

    @Override
    public Fournisseurs update(Fournisseurs fournisseur) {
        Optional<Fournisseurs> fournisseurPersiste = findOne(fournisseur.getId());

        if(fournisseurPersiste==null){
            return null;
        }
        Fournisseurs updateFournisseur=  fournisseurDaoRepo.save(fournisseur);
        return updateFournisseur;
    }

    @Override
    public void delete(Long id) {
        fournisseurDaoRepo.deleteById(id);

    }
}


