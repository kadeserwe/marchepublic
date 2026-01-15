

package com.example.demo.service;
import com.example.demo.dao.DepartementsDao;
import com.example.demo.model.Departements;
import com.example.demo.model.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class DepartementsServiceImpl implements IDepartementsService{


    @Autowired
   private DepartementsDao departementDaoRepo;


    @Override
    public Collection<Departements> findAll() {
        Collection<Departements> departements= (Collection<Departements>) departementDaoRepo.findAll();
        return departements;
    }

    @Override
    public Optional<Departements> findById(Long id) {
        Optional<Departements> departement = departementDaoRepo.findById(id);
        return departement;
    }

    @Override
    public Departements create(Departements departement) {
        if(departement.getId() != null){
            return null;

        }
        Departements saveDepartement= departementDaoRepo.save(departement);
        return saveDepartement;
    }

    @Override
    public Departements update(Departements departement) {
        Optional<Departements> departementPersiste = findById(departement.getId());

        if(departementPersiste==null){
            return null;
        }
        Departements updateDepartement=  departementDaoRepo.save(departement);
        return updateDepartement;
    }

    @Override
    public void delete(Long id) {
        departementDaoRepo.deleteById(id);

    }

    @Override
    public List<Departements> findRegionByDepartementId(Long region) {
        List<Departements> regionByDepartement=   departementDaoRepo.findDepartementByRegionId(region);
        return regionByDepartement;
    }
}


