

package com.example.demo.controller;

import com.example.demo.model.Communes;
import com.example.demo.model.Naissance;
import com.example.demo.service.ICommunesService;
import com.example.demo.service.ICommunesService;
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
public class CommunesController {

    @Autowired
    private ICommunesService communeService;

    @GetMapping("/communes")
    public ResponseEntity<Collection<Communes>> getCommunes() {
        Collection<Communes> communes= (Collection<Communes>) communeService.findAll();
        System.out.println("eee++++++++++++++++:"+communes);
        return new ResponseEntity<Collection<Communes>>(communes, HttpStatus.OK);
    }

    @GetMapping("/communes/{id}")
    public ResponseEntity<Optional<Communes>>getCommune(@PathVariable Long id) {
        Optional<Communes> commune= communeService.findById(id);
        if(commune==null){
           return new  ResponseEntity<Optional<Communes>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Communes>>(commune,HttpStatus.OK);
    }

    @GetMapping("/communesdep/{departement}")
    public ResponseEntity<List<Communes>> findByDepartementId(@PathVariable Long departement) {
        List<Communes> communesDepartementId= communeService.findByDepartementId(departement);
        if(communesDepartementId==null){
            return new  ResponseEntity<List<Communes>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Communes> >(communesDepartementId,HttpStatus.OK);
    }

   @PostMapping("/communes")
    public ResponseEntity<Communes> createCommune(@RequestBody Communes communecreate) {
       Communes saveCommune= communeService.create(communecreate);

        return new ResponseEntity<Communes>(saveCommune, HttpStatus.CREATED);
    }

    @PutMapping("/communes")
    public ResponseEntity<Communes> updateCommune(@RequestBody Communes communeCreate) {
        Communes saveCommune = communeService.update(communeCreate);

            return new ResponseEntity<Communes>(saveCommune, HttpStatus.OK);
    }
    @DeleteMapping("/communes/{id}")
    public ResponseEntity<Communes> deleteCommune(@PathVariable Long id) {
        // Optional<Contacts> contacts= contactsService.delete(id);
        // Contacts saveContacts = contactsService.update(contactscreate);
        communeService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}


