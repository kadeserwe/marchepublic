

package com.example.demo.service;

import com.example.demo.dao.CommandesDao;
import com.example.demo.model.Commandes;
import com.example.demo.model.Produits;
import com.example.demo.model.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CommandesServiceImpl implements ICommandesService{


    @Autowired
   private CommandesDao commandeDaoRepo;


    @Override
    public Collection<Commandes> findAll() {
        Collection<Commandes> commandes= (Collection<Commandes>) commandeDaoRepo.findAll();
        return commandes;
    }

    @Override
    public Optional<Commandes> findById(Long id) {
        Optional<Commandes> commande = commandeDaoRepo.findById(id);
        return commande;
    }

    @Override
    public Commandes create(Commandes commande) {
        if(commande.getId() != null){
            return null;

        }
        Commandes saveCommande= commandeDaoRepo.save(commande);
        return saveCommande;
    }

//    @Override
//    public Commandes update(Commandes commande) {
//        Optional<Commandes> commandePersiste = findOne(commande.getId());
//
//        if(commandePersiste==null){
//            return null;
//        }
//        Commandes updateCommande=  commandeDaoRepo.save(commande);
//        return updateCommande;
//    }

    @Override
    public Commandes update(Commandes commande) {
        Optional<Commandes> commandePersiste = findById(commande.getId());

        if(commandePersiste==null){
            return null;
        }
        Commandes updateCommande=  commandeDaoRepo.save(commande);
        return updateCommande;
    }

    @Override
    public void delete(Long id) {
        commandeDaoRepo.deleteById(id);

    }

    @Override
    public List<Commandes> findByClientId(Long commande) {
        return commandeDaoRepo.findByClientId(commande);
    }
}


