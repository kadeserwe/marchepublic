package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="Taux")
public class Taux implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Long valeur;

    public Taux() { }

    public Taux(Long id, String description, Long valeur) {
        this.id = id;

        this.description = description;
        this.valeur=valeur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getValeur() {
        return valeur;
    }

    public void setValeur(Long valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", valeur='" + valeur + '\'' +
                '}';
    }
}
