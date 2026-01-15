
package com.example.demo.dao;

import com.example.demo.model.Categories;
import com.example.demo.model.WebinarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IwebinarDao extends JpaRepository<WebinarModel, Long> {
    //public Optional<Categories> findById(Long id);
    public WebinarModel findById(int id);


}

