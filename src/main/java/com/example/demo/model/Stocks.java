package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="Stocks")
public class Stocks implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Long quantite;
    private String reference;
    private String utilisateur;
    private Date  dateCreation;


    @ManyToOne(optional = false)
  // @ManyToOne(cascade = {CascadeType.ALL})
    @NotNull
    @JsonIgnoreProperties(value = "produit", allowSetters = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Produits produit;

    public Stocks() { }

    public Stocks(Long id,  String description, Long quantite, String reference,
                  String utilisateur, Date dateCreation, Produits produit) {
        this.id = id;
        this.description = description;
        this.quantite = quantite;
        this.reference= reference;
        this.utilisateur=utilisateur;
        this.dateCreation=dateCreation;
        this.produit= produit;
       // this.categorie=categorie;
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

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }



    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }



    public Produits getProduit() {
        return produit;
    }

    public void setProduit(Produits produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", reference=" + reference +
                ", utilisateur=" + utilisateur +
                ", dateCreation=" + dateCreation +
                ", produit=" + produit +
                '}';
    }
}
