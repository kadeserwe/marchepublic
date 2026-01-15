package com.example.demo.service;

import com.example.demo.model.Individu;

import java.util.Collection;
import java.util.Optional;

public interface IIndividuService {
   public Collection<Individu> findAll();
    Optional<Individu> findOne (Long id);
    //Individu findById (Long id);
    Individu create (Individu individu);
    Individu update (Individu individu);
    void delete (Long id);

}
