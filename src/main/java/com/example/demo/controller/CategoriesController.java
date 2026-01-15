

package com.example.demo.controller;

import com.example.demo.model.Categories;
import com.example.demo.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
@CrossOrigin("http://localhost:4200")
public class CategoriesController {

    @Autowired
    private ICategoriesService categorieService;

    @GetMapping("/categories")
    public ResponseEntity<Collection<Categories>> getCategories() {
        Collection<Categories> categories= (Collection<Categories>) categorieService.findAll();
        return new ResponseEntity<Collection<Categories>>(categories, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Optional<Categories>>getCategorie(@PathVariable Long id) {
        Optional<Categories> categorie= categorieService.findById(id);
        if(categorie==null){
           return new  ResponseEntity<Optional<Categories>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Categories>>(categorie,HttpStatus.OK);
    }

   @PostMapping("/categories")
    public ResponseEntity<Categories> createCategorie(@RequestBody Categories categorieCreate) {
       Categories saveCategorie= categorieService.create(categorieCreate);

        return new ResponseEntity<Categories>(saveCategorie, HttpStatus.CREATED);
    }

    @PutMapping("/categories")
    public ResponseEntity<Categories> updateCategorie(@RequestBody Categories createCategorie) {
        Categories saveCategorie = categorieService.update(createCategorie);

            return new ResponseEntity<Categories>(saveCategorie, HttpStatus.OK);
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Categories> deleteCategorie(@PathVariable Long id) {
        categorieService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}


