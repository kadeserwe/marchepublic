

package com.example.demo.service;
import com.example.demo.dao.RegionsDao;
import com.example.demo.model.Communes;
import com.example.demo.model.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RegionsServiceImpl implements IRegionsService{


    @Autowired
   private RegionsDao regionDaoRepo;


    @Override
    public Collection<Regions> findAll() {
        Collection<Regions> regions= (Collection<Regions>) regionDaoRepo.findAll();
        return regions;
    }

    @Override
    public Optional<Regions> findById(Long id) {
        Optional<Regions> region = regionDaoRepo.findById(id);
        return region;
    }

    @Override
    public Regions create(Regions region) {
        if(region.getId() != null){
            return null;

        }
        Regions saveRegion= regionDaoRepo.save(region);
        return saveRegion;
    }

    @Override
    public Regions update(Regions region) {
        Optional<Regions> regionPersiste = findById(region.getId());

        if(regionPersiste==null){
            return null;
        }
        Regions updateRegion=  regionDaoRepo.save(region);
        return updateRegion;
    }

    @Override
    public void delete(Long id) {
        regionDaoRepo.deleteById(id);

    }


}


