
package com.example.demo.service;

import com.example.demo.dao.ContactsDao;
import com.example.demo.model.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ContactsServiceImpl /*implements IContactsService*/ {


    @Autowired
   private ContactsDao contactsDaoRepo;


   // @Override
  //1  public Page<Contacts> getAll(int pageNumbert , int pageSize ) {
       // Pageable page= PageRequest.of(pageNumbert, pageSize);
      //1 Pageable page = PageRequest.of(pageNumbert, pageSize);
   public Collection<Contacts> findAll() {
       Collection<Contacts> contacts =(Collection<Contacts>)   contactsDaoRepo.findAll();
        return contacts;
     //1 return   contactsDaoRepo.findAll(page);
       // return  contactsDaoRepo.findAll(page);
    }

    public Page<Contacts> getContactsPage(int pageNumber , int pageSize/*, String sortProperty*/) {
//Sort sort =Sort.by(Sort.Direction.ASC,"nom");
     //   Pageable page=null;
        Pageable  page= PageRequest.of(pageNumber, pageSize);
//        if(null!=sortProperty){
//
//            page= PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"sortProperty");
//        }else{
//           page= PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"prenom");
//        }

       return contactsDaoRepo.findAll(page) ;
    }



    public List<Contacts> findContactsProperty( String sortProperty) {




        return contactsDaoRepo.findAll(Sort.by(Sort.Direction.ASC,sortProperty)) ;
    }

  //  @Override
    public Optional<Contacts> findOne(Long id) {
        Optional<Contacts> contact = contactsDaoRepo.findById(id);
        return contact;
    }

   // @Override
    public Contacts create(Contacts contacts) {
        if(contacts.getId() != null){
            return null;

        }
        Contacts saveContacts = contactsDaoRepo.save(contacts);
        return saveContacts;
    }

   // @Override
    public Contacts update(Contacts contacts) {
        Optional<Contacts> contactPersiste = findOne(contacts.getId());

        if(contactPersiste==null){
            return null;
        }
        Contacts updateContacts =  contactsDaoRepo.save(contacts);
        return updateContacts;
    }

   // @Override
    public void delete(Long id) {
        contactsDaoRepo.deleteById(id);

    }


    public List<Contacts> searchContacts(String query) {
        List<Contacts> contacts = contactsDaoRepo.searchContacts(query);
                //searchProductsSQL(query);
        return contacts;
    }
}

