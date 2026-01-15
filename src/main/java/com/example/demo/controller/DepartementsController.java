

package com.example.demo.controller;

import com.example.demo.model.Departements;
import com.example.demo.service.IDepartementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
@CrossOrigin("http://localhost:4200")
public class DepartementsController {

    @Autowired
    private IDepartementsService departementService;

    @GetMapping("/departements")
    public ResponseEntity<Collection<Departements>> getdepartements() {
        Collection<Departements> departements= (Collection<Departements>) departementService.findAll();
        System.out.println("eee++++++++++++++++:"+departements);
        return new ResponseEntity<Collection<Departements>>(departements, HttpStatus.OK);
    }

    @GetMapping("/departements/{id}")
    public ResponseEntity<Optional<Departements>>getDepartement(@PathVariable Long id) {
        Optional<Departements> departement= departementService.findById(id);
        if(departement==null){
           return new  ResponseEntity<Optional<Departements>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Departements>>(departement,HttpStatus.OK);
    }

    @GetMapping("/departementsreg/{region}")
    public ResponseEntity<List<Departements>> findByDepartementId(@PathVariable Long region) {
        List<Departements> departementsRegionId= departementService.findRegionByDepartementId(region);
        if(departementsRegionId==null){
            return new  ResponseEntity<List<Departements>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Departements> >(departementsRegionId,HttpStatus.OK);
    }

   @PostMapping("/departements")
    public ResponseEntity<Departements> createDepartement(@RequestBody Departements departementCreate) {
       Departements saveDepartement= departementService.create(departementCreate);

        return new ResponseEntity<Departements>(saveDepartement, HttpStatus.CREATED);
    }

    @PutMapping("/departements")
    public ResponseEntity<Departements> updateDepartement(@RequestBody Departements departementCreate) {
        Departements saveDepartement = departementService.update(departementCreate);

            return new ResponseEntity<Departements>(saveDepartement, HttpStatus.OK);
    }
    @DeleteMapping("/departements/{id}")
    public ResponseEntity<Departements> deleteDepartement(@PathVariable Long id) {
        departementService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}


