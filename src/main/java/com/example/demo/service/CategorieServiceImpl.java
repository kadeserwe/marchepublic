

package com.example.demo.service;

import com.example.demo.dao.CategoriesDao;
import com.example.demo.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements ICategoriesService{


    @Autowired
   private CategoriesDao categorieDaoRepo;


    @Override
    public Collection<Categories> findAll() {
        Collection<Categories> categories= (Collection<Categories>) categorieDaoRepo.findAll();
        return categories;
    }

    @Override
    public Optional<Categories> findById(Long id) {
        Optional<Categories> categorie = categorieDaoRepo.findById(id);
        return categorie;
    }

    @Override
    public Categories create(Categories categorie) {
        if(categorie.getId() != null){
            return null;

        }
        Categories saveCategorie= categorieDaoRepo.save(categorie);
        return saveCategorie;
    }

    @Override
    public Categories update(Categories categorie) {
        Optional<Categories> categoriePersiste = findById(categorie.getId());

        if(categoriePersiste==null){
            return null;
        }
        Categories updateCategorie=  categorieDaoRepo.save(categorie);
        return updateCategorie;
    }

    @Override
    public void delete(Long id) {
        categorieDaoRepo.deleteById(id);

    }
}


