

package com.example.demo.service;

import com.example.demo.dao.JugementDao;
import com.example.demo.model.Jugement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class JugementServiceImpl implements IJugementService{


    @Autowired
   private JugementDao jugementDaoRepo;


    @Override
    public Collection<Jugement> findAll() {
        Collection<Jugement> jugements= (Collection<Jugement>) jugementDaoRepo.findAll();
        return jugements;
    }

    @Override
    public Optional<Jugement> findOne(Long id) {
        Optional<Jugement> jugement = jugementDaoRepo.findById(id);
        return jugement;
    }

    @Override
    public Jugement create(Jugement jugement) {
        if(jugement.getId() != null){
            return null;

        }
        Jugement saveJugement = jugementDaoRepo.save(jugement);
        return saveJugement;
    }

    @Override
    public Jugement update(Jugement jugement) {
        Optional<Jugement> jugementPersiste = findOne(jugement.getId());

        if(jugementPersiste==null){
            return null;
        }
        Jugement updateJugement=  jugementDaoRepo.save(jugement);
        return updateJugement;
    }

    @Override
    public void delete(Long id) {
        jugementDaoRepo.deleteById(id);

    }
}


