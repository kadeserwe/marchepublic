
package com.example.demo.service;

import com.example.demo.model.Clients;
import com.example.demo.model.Jugement;

import java.util.Collection;
import java.util.Optional;

public interface IClientsService {
    public Collection<Clients> findAll();
    Optional<Clients> findOne (Long id);
    Clients create (Clients client);
    Clients update (Clients client);
    void delete (Long id);

}


