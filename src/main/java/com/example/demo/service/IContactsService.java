

package com.example.demo.service;

import com.example.demo.model.Contacts;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IContactsService {
   public Page<Contacts> findAll(int  pageNumber , int  pageSize);
    Optional<Contacts> findOne (Long id);
    Contacts create (Contacts contacts);
    Contacts update (Contacts contacts);
    void  delete (Long id);
    List<Contacts> searchContacts(String query);

}


