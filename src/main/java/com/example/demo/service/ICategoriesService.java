
package com.example.demo.service;

import com.example.demo.model.Categories;

import java.util.Collection;
import java.util.Optional;

public interface ICategoriesService {
    public Collection<Categories> findAll();
    Optional<Categories> findById (Long id);
    Categories create (Categories categorie);
    Categories update (Categories categorie);
    void delete (Long id);

}


