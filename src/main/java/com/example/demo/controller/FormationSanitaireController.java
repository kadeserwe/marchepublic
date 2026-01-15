
package com.example.demo.controller;

import com.example.demo.model.FormationSanitaire;
import com.example.demo.service.IFormationSanitaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
public class FormationSanitaireController {

    @Autowired
    private IFormationSanitaireService formationSanitaireService;

    @GetMapping("/formationSanitaires")
    public ResponseEntity<Collection<FormationSanitaire>> getFormationSanitaires() {
        Collection<FormationSanitaire> formationSanitaires= (Collection<FormationSanitaire>) formationSanitaireService.findAll();
        return new ResponseEntity<Collection<FormationSanitaire>>(formationSanitaires, HttpStatus.OK);
    }

    @GetMapping(value="/formationSanitaires/{id}")
    public ResponseEntity<Optional<FormationSanitaire>> getFormationSanitaire(@PathVariable Long id) {
        Optional<FormationSanitaire> formationSanitaire= formationSanitaireService.findOne(id);
        if(formationSanitaire==null){
           return new  ResponseEntity<Optional<FormationSanitaire>>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<FormationSanitaire>>(formationSanitaire, HttpStatus.OK);
    }

   @PostMapping("/formationSanitaires")
    public ResponseEntity<FormationSanitaire> createFormationSanitaire(@RequestBody FormationSanitaire formationSanitairecreate, @RequestParam("file" ) MultipartFile file) {

        FormationSanitaire saveFormationSanitaire= formationSanitaireService.create(formationSanitairecreate);

        return new ResponseEntity<FormationSanitaire>(saveFormationSanitaire, HttpStatus.CREATED);
    }
}

