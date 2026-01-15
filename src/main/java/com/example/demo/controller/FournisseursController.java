

package com.example.demo.controller;

import com.example.demo.model.Fournisseurs;
import com.example.demo.service.IFournisseursService;
import com.example.demo.service.IFournisseursService;
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
public class FournisseursController {

    @Autowired
    private IFournisseursService fournisseurService;

    @GetMapping("/fournisseurs")
    public ResponseEntity<Collection<Fournisseurs>> getFournisseurs() {
        Collection<Fournisseurs> fournisseurs= (Collection<Fournisseurs>) fournisseurService.findAll();
        return new ResponseEntity<Collection<Fournisseurs>>(fournisseurs, HttpStatus.OK);
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Optional<Fournisseurs>>getfournisseurs(@PathVariable Long id) {
        Optional<Fournisseurs> fournisseur= fournisseurService.findOne(id);
        if(fournisseur==null){
           return new  ResponseEntity<Optional<Fournisseurs>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Fournisseurs>>(fournisseur,HttpStatus.OK);
    }

   @PostMapping("/fournisseurs")
    public ResponseEntity<Fournisseurs> createfournisseurs(@RequestBody Fournisseurs fournisseurscreate) {
       Fournisseurs saveFournisseur= fournisseurService.create(fournisseurscreate);

        return new ResponseEntity<Fournisseurs>(saveFournisseur, HttpStatus.CREATED);
    }

    @PutMapping("/fournisseurs")
    public ResponseEntity<Fournisseurs> updatefournisseurs(@RequestBody Fournisseurs fournisseurscreate) {
        Fournisseurs saveFournisseur = fournisseurService.update(fournisseurscreate);

            return new ResponseEntity<Fournisseurs>(saveFournisseur, HttpStatus.OK);
    }
    @DeleteMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseurs> deletefournisseurs(@PathVariable Long id) {
        // Optional<Contacts> contacts= contactsService.delete(id);
        // Contacts saveContacts = contactsService.update(contactscreate);
        fournisseurService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}


