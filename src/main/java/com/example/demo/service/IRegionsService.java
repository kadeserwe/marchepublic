
package com.example.demo.service;

import com.example.demo.model.Communes;
import com.example.demo.model.Regions;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IRegionsService {
    public Collection<Regions> findAll();
    Optional<Regions> findById (Long id);
    Regions create (Regions region);
    Regions update (Regions region);
    void delete (Long id);


}


