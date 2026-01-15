

package com.example.demo.service;

import com.example.demo.dao.NaissanceDao;
import com.example.demo.model.Naissance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class NaissanceServiceImpl implements INaissanceService{


    @Autowired
   private NaissanceDao naissanceDaoRepo;


    @Override
    public Collection<Naissance> findAll() {
        Collection<Naissance> naissances= (Collection<Naissance>) naissanceDaoRepo.findAll();
        return naissances;
    }

    @Override
    public Optional<Naissance> findOne(Long id) {
        Optional<Naissance> naissance = naissanceDaoRepo.findById(id);
        return naissance;
    }

    @Override
    public Naissance create(Naissance naissance) {
        if(naissance.getId() != null){
            return null;

        }
        Naissance saveNaissance = naissanceDaoRepo.save(naissance);
        return saveNaissance;
    }

    @Override
    public Naissance update(Naissance naissance) {
        Optional<Naissance> naissancePersiste = findOne(naissance.getId());

        if(naissancePersiste==null){
            return null;
        }
        Naissance updateNaissance=  naissanceDaoRepo.save(naissance);
        return updateNaissance;
    }

    @Override
    public void delete(Long id) {
        naissanceDaoRepo.deleteById(id);

    }

    @Override
    public List<Naissance> findBynumeroActe(Integer numeroActe) {
        List<Naissance> naissancesBynumeroActe=  naissanceDaoRepo.findBynumeroActe(numeroActe);
        return naissancesBynumeroActe;
    }


/*@Override
    public List<Naissance> findBynumeroActe(int numeroActe) {
        List<Naissance> naissancesBynumeroActe=  naissanceDaoRepo.findBynumeroActe(numeroActe);
        return naissancesBynumeroActe;
    }*/


}


