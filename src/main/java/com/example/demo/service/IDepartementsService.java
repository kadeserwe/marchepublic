
package com.example.demo.service;


import com.example.demo.model.Departements;
import com.example.demo.model.Regions;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IDepartementsService {
    public Collection<Departements> findAll();
    Optional<Departements> findById (Long id);
    Departements create (Departements departement);
    Departements update (Departements departement);
    void delete (Long id);
    public List<Departements> findRegionByDepartementId(Long region);

}


