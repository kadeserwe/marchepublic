

package com.example.demo.service;
import com.example.demo.dao.CommunesDao;
import com.example.demo.dao.CommunesDao;
import com.example.demo.model.Communes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CommunesServiceImpl implements ICommunesService{


    @Autowired
   private CommunesDao communeDaoRepo;


    @Override
    public Collection<Communes> findAll() {
        Collection<Communes> communes= (Collection<Communes>) communeDaoRepo.findAll();
        return communes;
    }

    @Override
    public Optional<Communes> findById(Long id) {
        Optional<Communes> commune = communeDaoRepo.findById(id);
        return commune;
    }

    @Override
    public Communes create(Communes commune) {
        if(commune.getId() != null){
            return null;

        }
        Communes savecommune= communeDaoRepo.save(commune);
        return savecommune;
    }

    @Override
    public Communes update(Communes commune) {
        Optional<Communes> communePersiste = findById(commune.getId());

        if(communePersiste==null){
            return null;
        }
        Communes updatecommune=  communeDaoRepo.save(commune);
        return updatecommune;
    }

    @Override
    public void delete(Long id) {
        communeDaoRepo.deleteById(id);

    }

    @Override
    public List<Communes> findByDepartementId(Long departement) {
        List<Communes> communeByDepartement=   communeDaoRepo.findByDepartementId(departement);
        return communeByDepartement;
    }
}


