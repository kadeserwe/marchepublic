
package com.example.demo.dao;
import com.example.demo.model.Fournisseurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseursDao extends JpaRepository<Fournisseurs, Long> {
    public Optional<Fournisseurs> findById(Long id);


}

