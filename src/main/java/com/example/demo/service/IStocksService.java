
package com.example.demo.service;

import com.example.demo.model.Produits;
import com.example.demo.model.Stocks;

import java.util.Collection;
import java.util.Optional;

public interface IStocksService {
    public Collection<Stocks> findAll();
    Optional<Stocks> findById (Long id);
    Stocks create (Stocks stocks);
    Stocks update (Stocks stock);
    void delete (Long id);

}


