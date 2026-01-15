
package com.example.demo.dao;

import com.example.demo.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContactsDao extends JpaRepository<Contacts, Long> {
    public Optional<Contacts> findById(Long id);
    @Query("SELECT p FROM Contacts p WHERE " +
            "LOWER(p.nom) LIKE LOWER(CONCAT('%',:query, '%'))" +
            "Or LOWER(p.prenom) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Contacts> searchContacts(String query);


}

