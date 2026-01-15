package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="Commandes")
public class Commandes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String NumeroCommande;
    private String libelle;
    private Long quantiteCommande;
    private String utilisateur;
    private Long total;


    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "client", allowSetters = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Clients  client;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "produit", allowSetters = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Produits  produit;

    public Commandes() { }

    public Commandes(Long id, String numeroCommande, String libelle, String  utilisateur,Long quantiteCommande, Long total,Clients client, Produits  produit) {
        this.id = id;
        NumeroCommande = numeroCommande;
        this.libelle = libelle;
        this.quantiteCommande = quantiteCommande;
        this.total=total;
        this.utilisateur= utilisateur;
        this.client = client;
        this.produit =produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCommande() {
        return NumeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        NumeroCommande = numeroCommande;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getquantiteCommande() {
        return quantiteCommande;
    }

    public void setquantiteCommande(Long quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;

    }

    public Produits getProduit() {
        return produit;
    }

    public void setProduit(Produits produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Commandes{" +
                "id=" + id +
                ", NumeroCommande='" + NumeroCommande + '\'' +
                ", libelle='" + libelle + '\'' +
                ", quantiteCommande=" + quantiteCommande +
                ", total=" + total +
                ", utilisateur=" + utilisateur +
                ", client=" + client +
                ", produit=" + produit +
                '}';
    }
}
