

package com.example.demo.service;
import com.example.demo.dao.ProduitsDao;
import com.example.demo.model.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitsServiceImpl implements IProduitsService{


    @Autowired
   private ProduitsDao produitDaoRepo;


    @Override
    public Collection<Produits> findAll() {
        Collection<Produits> produits= (Collection<Produits>) produitDaoRepo.findAll();
        return produits;
    }

    @Override
    public Optional<Produits> findById(Long id) {
        Optional<Produits> produit = produitDaoRepo.findById(id);
        return produit;
    }

    @Override
    public Produits create(Produits produit) {
        if(produit.getId() != null){
            return null;

        }
        Produits saveProduit= produitDaoRepo.save(produit);
        return saveProduit;
    }

    @Override
    public Produits update(Produits produit) {
        Optional<Produits> produitsPersiste = findById(produit.getId());

        if(produitsPersiste==null){
            return null;
        }
        Produits updateProduit=  produitDaoRepo.save(produit);
        return updateProduit;
    }

    @Override
    public void delete(Long id) {
        produitDaoRepo.deleteById(id);

    }

    @Override
    public List<Produits> findByFournisseurId(Long fournisseur) {
        return produitDaoRepo.findByFournisseurId(fournisseur);
    }
}


