package com.example.demo.controller;

import com.example.demo.model.Individu;
import com.example.demo.service.IIndividuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
public class IndividuController {

    @Autowired
    private IIndividuService individuService;

    @GetMapping("/individus")
    public ResponseEntity<Collection<Individu>> getIndividus() {
        Collection<Individu> individus= (Collection<Individu>) individuService.findAll();
        return new ResponseEntity<Collection<Individu>>(individus, HttpStatus.OK);
    }

   @GetMapping("/individus/{id}")
    public ResponseEntity<Optional<Individu>> getIndividu(@PathVariable Long id) {
      //  Optional<Individu>
       Optional<Individu> individu= individuService.findOne(id);
        if(individu==null){
           return new  ResponseEntity<Optional<Individu>> (HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Individu>> (individu, HttpStatus.OK);
    }

   @PostMapping("/individus")
    public ResponseEntity<Individu> createIndividu(@RequestBody Individu individucreate) {
       Individu saveIndividu= individuService.create(individucreate);

        return new ResponseEntity<Individu>(saveIndividu, HttpStatus.CREATED);
    }
}
