

package com.example.demo.controller;

import com.example.demo.model.Naissance;
import com.example.demo.service.INaissanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
public class NaissanceController {

    @Autowired
    private INaissanceService naissanceService;

    @GetMapping("/naissances")
    public ResponseEntity<Collection<Naissance>> getNaissances() {
        Collection<Naissance> naissances= (Collection<Naissance>) naissanceService.findAll();
        return new ResponseEntity<Collection<Naissance>>(naissances, HttpStatus.OK);
    }

    @GetMapping("/naissances/{id}")
    public ResponseEntity<Optional<Naissance>> getNaissance(@PathVariable Long id) {
        Optional<Naissance> naissance= naissanceService.findOne(id);
        if(naissance==null){
           return new  ResponseEntity<Optional<Naissance>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Naissance>>(naissance,HttpStatus.OK);
    }

    @GetMapping("/naissancesnum/{numeroActe}")
    public ResponseEntity<List<Naissance> > findBynumeroActe(@PathVariable Integer numeroActe) {
        List<Naissance> naissanceNumeroActe= naissanceService.findBynumeroActe(numeroActe);
        if(naissanceNumeroActe==null){
            return new  ResponseEntity<List<Naissance>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Naissance> >(naissanceNumeroActe,HttpStatus.OK);
    }

   @PostMapping("/naissances")
    public ResponseEntity<Naissance> createNaissance(@RequestBody Naissance naissancecreate) {
       Naissance saveNaissance= naissanceService.create(naissancecreate);

        return new ResponseEntity<Naissance>(saveNaissance, HttpStatus.CREATED);
    }
}

