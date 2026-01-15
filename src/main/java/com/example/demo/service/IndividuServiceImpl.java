package com.example.demo.service;

import com.example.demo.dao.IndividuDao;
import com.example.demo.model.Individu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class IndividuServiceImpl implements IIndividuService{


    @Autowired
   private IndividuDao individuDaoRepo;


    @Override
    public Collection<Individu> findAll() {
        Collection<Individu> individus= (Collection<Individu>) individuDaoRepo.findAll();
        return individus;
    }

    @Override
    public Optional<Individu> findOne(Long id) {
        Optional<Individu>  individu = individuDaoRepo.findById(id);
        return individu;
    }


  /*  @Override
    public Individu findByeId(Long id) {
        Individu individu = individuDaoRepo.getById(id);
        return individu;
    }
*/
    @Override
    public Individu create(Individu individu) {
        if(individu.getId() != null){
            return null;

        }
        Individu saveIndividu = individuDaoRepo.save(individu);
        return saveIndividu;
    }

    @Override
    public Individu update(Individu individu) {
        Optional<Individu> individuPersiste = findOne(individu.getId());

        if(individuPersiste==null){
            return null;
        }
        Individu updateIndividu=  individuDaoRepo.save(individu);
        return updateIndividu;
    }

    @Override
    public void delete(Long id) {
        individuDaoRepo.deleteById(id);

    }
}
