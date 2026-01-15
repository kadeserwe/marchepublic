

package com.example.demo.service;

import com.example.demo.model.Naissance;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface INaissanceService {
   public Collection<Naissance> findAll();
    Optional<Naissance> findOne (Long id);
    Naissance create (Naissance naissance);
    Naissance update (Naissance naissance);
    void delete (Long id);
    public List<Naissance> findBynumeroActe(Integer numeroActe);

}


