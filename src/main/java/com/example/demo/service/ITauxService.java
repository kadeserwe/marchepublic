
package com.example.demo.service;

import com.example.demo.model.Taux;

import java.util.Collection;
import java.util.Optional;

public interface ITauxService {
    public Collection<Taux> findAll();
    Optional<Taux> findOne (Long id);
    Taux create (Taux taux);
    Taux update (Taux taux);
    void delete (Long id);

}


