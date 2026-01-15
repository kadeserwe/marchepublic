
package com.example.demo.controller;

import com.example.demo.model.Contacts;
import com.example.demo.model.FormationSanitaire;
import com.example.demo.service.ContactsServiceImpl;
//import com.example.demo.service.IContactsService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.jetty.core.AbstractKeycloakJettyAuthenticator;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.util.*;

@RestController
@RequestMapping("/api")
//@Transactional
//@CrossOrigin(origins = "http://localhost:4200/")
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin("http://localhost:4200")
public class ContactsController {

    @Autowired
    private ContactsServiceImpl contactsService;

    @GetMapping("/contacts")
   // @PreAuthorize("hasAuthority('user')")
    public ResponseEntity<Collection<Contacts>> getContacts() {
        Collection<Contacts> contacts= (Collection<Contacts>) contactsService.findAll();
        return new ResponseEntity<Collection<Contacts>>(contacts, HttpStatus.OK);
    }


    @GetMapping("/contactsort/{sortProperty}")
    public ResponseEntity<Collection<Contacts>> findContactsProperty(@PathVariable String sortProperty) {
        Collection<Contacts> contacts= (Collection<Contacts>) contactsService.findContactsProperty(sortProperty);
        return new ResponseEntity<Collection<Contacts>>(contacts, HttpStatus.OK);
    }

    @GetMapping("/jwt")
    @ResponseBody
    public Map<String, String > map(HttpServletRequest request) {
        KeycloakAuthenticationToken token=(KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal=(KeycloakPrincipal)token.getPrincipal();
        KeycloakSecurityContext keycloakSecurityContext=principal.getKeycloakSecurityContext();
        Map<String, String> map =new HashMap<>();
        map.put("access_token", keycloakSecurityContext.getTokenString());
        return map;
    }

//    @GetMapping("/contacts")
//        /* public ResponseEntity<*/Page<Contacts> getContacts(@RequestParam int pageSize , @RequestParam int pageNumber  ) {
//       // Page<Contacts> contacts =  contactsService.findAll(pageNumber ,pageSize);
//       // return contacts;//new ResponseEntity<Page<Contacts>>((Page<Contacts>) contacts, HttpStatus.OK);
//        return  contactsService.getAll(pageNumber ,pageSize);
//    }

//    @RequestMapping(value="/contacts/pagination/page={pageNumber}&pagesize={pageSize}", method=RequestMethod.GET)
//    public Page<Contacts> contactsPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
//
//        return contactsService.getContactsPage(pageNumber,pageSize/*, null*/ );
//    }

    @GetMapping("/contacts/search")
    public ResponseEntity<List<Contacts>> searchContacts(@RequestParam("query") String query){
        return ResponseEntity.ok(contactsService.searchContacts(query));
    }


    @GetMapping("/contacts/pagination")
    public Page<Contacts> contactsPage(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
        return contactsService.getContactsPage(pageNumber,pageSize );
    }

//    @RequestMapping(value="/pagination/{pageNumber}/{pageSize}/{sortProperty", method=RequestMethod.GET)
//    public Page<Contacts> contactsPage(
//            @PathVariable Integer pageNumber,
//            @PathVariable Integer pageSize,
//            @PathVariable String sortProperty) {
//
//        return contactsService.getContactsPage(pageNumber,pageSize, sortProperty );
//    }

    @GetMapping("contacts/{id}")
    public ResponseEntity<Optional<Contacts>> getContactsId(@PathVariable Long id) {
        Optional<Contacts> contacts= contactsService.findOne(id);
        if(contacts==null){
           return new  ResponseEntity<Optional<Contacts>> (HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Contacts>> (contacts, HttpStatus.OK);
    }

   @PostMapping("/contacts")
    public ResponseEntity<Contacts> createContacts(@RequestBody Contacts contactscreate) {
       Contacts saveContacts = contactsService.create(contactscreate);

        return new ResponseEntity<Contacts>(saveContacts, HttpStatus.CREATED);
    }

    @PutMapping("/contacts")
    public ResponseEntity<Contacts> updateContacts(@RequestBody Contacts contactscreate) {
        Contacts saveContacts = contactsService.update(contactscreate);

        return new ResponseEntity<Contacts>(saveContacts, HttpStatus.OK);
    }
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Contacts> deleteContacts(@PathVariable Long id) {
       // Optional<Contacts> contacts= contactsService.delete(id);
       // Contacts saveContacts = contactsService.update(contactscreate);
         contactsService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }



}

