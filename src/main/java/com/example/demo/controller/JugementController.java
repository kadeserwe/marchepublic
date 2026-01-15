

package com.example.demo.controller;

import com.example.demo.model.Jugement;
import com.example.demo.service.IJugementService;
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
public class JugementController {

    @Autowired
    private IJugementService jugementService;

    @GetMapping("/jugements")
    public ResponseEntity<Collection<Jugement>> getJugements() {
        Collection<Jugement> jugements= (Collection<Jugement>) jugementService.findAll();
        return new ResponseEntity<Collection<Jugement>>(jugements, HttpStatus.OK);
    }

    @GetMapping("/jugements/{id}")
    public ResponseEntity<Optional<Jugement>>getJugement(@PathVariable Long id) {
        Optional<Jugement> jugement= jugementService.findOne(id);
        if(jugement==null){
           return new  ResponseEntity<Optional<Jugement>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Jugement>>(jugement,HttpStatus.OK);
    }

   @PostMapping("/jugements")
    public ResponseEntity<Jugement> createJugement(@RequestBody Jugement jugementcreate) {
       Jugement saveJugement= jugementService.create(jugementcreate);

        return new ResponseEntity<Jugement>(saveJugement, HttpStatus.CREATED);
    }
}


