
package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="formationSanitaire")

public class FormationSanitaire implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private  String type;


    public FormationSanitaire(){}
    public FormationSanitaire(Long id, String type, String nom) {
        this.id = id;
        this.type = type;
        this.nom = nom;

            }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    @Override
    public String toString() {
        return "formationSanitaire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +

                '}';
    }
}

