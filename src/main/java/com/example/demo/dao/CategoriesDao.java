
package com.example.demo.dao;
import javax.transaction.Transactional;
import com.example.demo.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//@Transactional
public interface CategoriesDao extends JpaRepository<Categories, Long> {
    public Optional<Categories> findById(Long id);


}

