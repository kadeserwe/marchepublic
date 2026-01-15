

package com.example.demo.service;
import com.example.demo.dao.TauxDao;
import com.example.demo.model.Taux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TauxServiceImpl implements ITauxService{


    @Autowired
   private TauxDao tauxDaoRepo;


    @Override
    public Collection<Taux> findAll() {
        Collection<Taux> taux= (Collection<Taux>) tauxDaoRepo.findAll();
        return taux;
    }

    @Override
    public Optional<Taux> findOne(Long id) {
        Optional<Taux> taux = tauxDaoRepo.findById(id);
        return taux;
    }

    @Override
    public Taux create(Taux taux) {
        if(taux.getId() != null){
            return null;

        }
        Taux saveTaux= tauxDaoRepo.save(taux);
        return saveTaux;
    }

    @Override
    public Taux update(Taux taux) {
        Optional<Taux> tauxPersiste = findOne(taux.getId());

        if(tauxPersiste==null){
            return null;
        }
        Taux updateTaux=  tauxDaoRepo.save(taux);
        return updateTaux;
    }

    @Override
    public void delete(Long id) {
        tauxDaoRepo.deleteById(id);

    }
}


