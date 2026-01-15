

package com.example.demo.service;
import com.example.demo.dao.StocksDao;
import com.example.demo.model.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StocksServiceImpl implements IStocksService{


    @Autowired
   private StocksDao stockDaoRepo;


    @Override
    public Collection<Stocks> findAll() {
        Collection<Stocks> stock= (Collection<Stocks>) stockDaoRepo.findAll();
        return stock;
    }

    @Override
    public Optional<Stocks> findById(Long id) {
        Optional<Stocks> stock = stockDaoRepo.findById(id);
        return stock;
    }

    @Override
    public Stocks create(Stocks stock) {
        if(stock.getId() != null){
            return null;

        }
        Stocks saveStock= stockDaoRepo.save(stock);
        return saveStock;
    }

    @Override
    public Stocks update(Stocks stock) {
        Optional<Stocks> stockPersiste = findById(stock.getId());

        if(stockPersiste==null){
            return null;
        }
        Stocks updateStock=  stockDaoRepo.save(stock);
        return updateStock;
    }

    @Override
    public void delete(Long id) {
        stockDaoRepo.deleteById(id);

    }
}


