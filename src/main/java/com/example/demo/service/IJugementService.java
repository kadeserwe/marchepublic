
package com.example.demo.service;

import com.example.demo.model.Jugement;

import java.util.Collection;
import java.util.Optional;

public interface IJugementService {
    public Collection<Jugement> findAll();
    Optional<Jugement> findOne (Long id);
    Jugement create (Jugement jugement);
    Jugement update (Jugement jugement);
    void delete (Long id);

}


