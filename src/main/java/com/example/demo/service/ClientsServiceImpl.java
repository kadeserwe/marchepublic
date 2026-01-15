

package com.example.demo.service;

import com.example.demo.dao.ClientsDao;
import com.example.demo.dao.JugementDao;
import com.example.demo.model.Clients;
import com.example.demo.model.Jugement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClientsServiceImpl implements IClientsService{


    @Autowired
   private ClientsDao clientDaoRepo;


    @Override
    public Collection<Clients> findAll() {
        Collection<Clients> clients= (Collection<Clients>) clientDaoRepo.findAll();
        return clients;
    }

    @Override
    public Optional<Clients> findOne(Long id) {
        Optional<Clients> client = clientDaoRepo.findById(id);
        return client;
    }

    @Override
    public Clients create(Clients client) {
        if(client.getId() != null){
            return null;

        }
        Clients saveClient= clientDaoRepo.save(client);
        return saveClient;
    }

    @Override
    public Clients update(Clients client) {
        Optional<Clients> clientPersiste = findOne(client.getId());

        if(clientPersiste==null){
            return null;
        }
        Clients updateClient=  clientDaoRepo.save(client);
        return updateClient;
    }

    @Override
    public void delete(Long id) {
        clientDaoRepo.deleteById(id);

    }
}


