
package com.example.demo.service;

import com.example.demo.model.Fournisseurs;

import java.util.Collection;
import java.util.Optional;

public interface IFournisseursService {
    public Collection<Fournisseurs> findAll();
    Optional<Fournisseurs> findOne (Long id);
    Fournisseurs create (Fournisseurs fournisseur);
    Fournisseurs update (Fournisseurs fournisseur);
    void delete (Long id);

}


