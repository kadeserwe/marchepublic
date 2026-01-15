package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="Fournisseurs")
public class Fournisseurs implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String codeClient;
    private Long telephone;
    private Long mobile;
    private String email;
    private String adresse;

    public Fournisseurs() { }

    public Fournisseurs(Long id, String nom, String prenom, String codeClient, Long telephone, Long mobile, String email, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.codeClient = codeClient;
        this.telephone = telephone;
        this.mobile = mobile;
        this.email = email;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", codeClient='" + codeClient + '\'' +
                ", telephone=" + telephone +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
