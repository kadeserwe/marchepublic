
package com.example.demo.service;


import com.example.demo.model.Communes;
import com.example.demo.model.Naissance;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ICommunesService {
    public Collection<Communes> findAll();
    Optional<Communes> findById (Long id);
    Communes create (Communes communes);
    Communes update (Communes commune);
    void delete (Long id);
    public List<Communes> findByDepartementId(Long departement);

}


