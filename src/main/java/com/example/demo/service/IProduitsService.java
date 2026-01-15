
package com.example.demo.service;

import com.example.demo.model.Produits;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IProduitsService {
    public Collection<Produits> findAll();
    Optional<Produits> findById (Long id);
    Produits create (Produits produit);
    Produits update (Produits produit);
    void delete (Long id);

    List<Produits> findByFournisseurId (Long  fournisseur);

}


