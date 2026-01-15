

package com.example.demo.controller;

import com.example.demo.model.Clients;
import com.example.demo.model.Contacts;
import com.example.demo.model.Departements;
import com.example.demo.service.IClientsService;
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
public class ClientsController {

    @Autowired
    private IClientsService clientService;

    @GetMapping("/clients")
    public ResponseEntity<Collection<Clients>> getClients() {
        Collection<Clients> clients= (Collection<Clients>) clientService.findAll();
        return new ResponseEntity<Collection<Clients>>(clients, HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Optional<Clients>>getClient(@PathVariable Long id) {
        Optional<Clients> client= clientService.findOne(id);
        if(client==null){
           return new  ResponseEntity<Optional<Clients>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Clients>>(client,HttpStatus.OK);
    }

   @PostMapping("/clients")
    public ResponseEntity<Clients> createClient(@RequestBody Clients clientCreate) {
       Clients saveClient= clientService.create(clientCreate);
//
//        return new ResponseEntity<Clients>(saveClient, HttpStatus.CREATED);
       System.out.println( clientCreate);
       System.out.println("++++++++++Clientcreate+++++++++++++");
       System.out.println( clientCreate.getNomCommune());

//       for(Departements de :  clientCreate.getRegion().getDepartements()){
//
//           System.out.println("++++++++++Clientcreate+++++++++++++");
//          // System.out.println( de.getNomDepartement());
//           System.out.println("++++++++++Clientcreate+++++++++++++");
//       }
       //System.out.println(clientCreate);
      // System.out.println(clientCreate.getRegion().getDepartements());

      // System.out.println("++++++++++Clientcreate+++++++++++++");
      // return new ResponseEntity<Clients>(clientCreate, HttpStatus.CREATED);
       return new ResponseEntity<Clients>(saveClient, HttpStatus.CREATED);
    }

    @PutMapping("/clients")
    public ResponseEntity<Clients> updateClient(@RequestBody Clients clientcreate) {
        Clients saveClient = clientService.update(clientcreate);

            return new ResponseEntity<Clients>(saveClient, HttpStatus.OK);
    }
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Clients> deleteClient(@PathVariable Long id) {
        // Optional<Contacts> contacts= contactsService.delete(id);
        // Contacts saveContacts = contactsService.update(contactscreate);
        clientService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}


