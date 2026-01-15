

package com.example.demo.controller;
;
import com.example.demo.model.Taux;
import com.example.demo.service.ITauxService;
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
public class TauxController {

    @Autowired
    private ITauxService tauxService;

    @GetMapping("/taux")
    public ResponseEntity<Collection<Taux>> getTaux() {
        Collection<Taux> taux= (Collection<Taux>) tauxService.findAll();
        return new ResponseEntity<Collection<Taux>>(taux, HttpStatus.OK);
    }

    @GetMapping("/taux/{id}")
    public ResponseEntity<Optional<Taux>>getTaux(@PathVariable Long id) {
        Optional<Taux> taux= tauxService.findOne(id);
        if(taux==null){
           return new  ResponseEntity<Optional<Taux>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Taux>>(taux,HttpStatus.OK);
    }

   @PostMapping("/taux")
    public ResponseEntity<Taux> createTaux(@RequestBody Taux tauxCreate) {
       Taux saveTaux= tauxService.create(tauxCreate);

        return new ResponseEntity<Taux>(saveTaux, HttpStatus.CREATED);
    }

    @PutMapping("/taux")
    public ResponseEntity<Taux> updateTaux(@RequestBody Taux createTaux) {
        Taux saveTaux = tauxService.update(createTaux);

            return new ResponseEntity<Taux>(saveTaux, HttpStatus.OK);
    }
    @DeleteMapping("/taux/{id}")
    public ResponseEntity<Taux> deleteTaux(@PathVariable Long id) {
        tauxService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}


