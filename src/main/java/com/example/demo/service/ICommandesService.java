
package com.example.demo.service;

import com.example.demo.model.Commandes;
import com.example.demo.model.Produits;
import com.example.demo.model.Stocks;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ICommandesService {
    public Collection<Commandes> findAll();
    Optional<Commandes> findById (Long id);
    Commandes create (Commandes commande);
    Commandes update (Commandes commande);
    void delete (Long id);
    List<Commandes> findByClientId (Long  client);




}


