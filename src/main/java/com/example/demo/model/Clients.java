package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="Clients")
public class Clients implements Serializable {
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
    @Column(name = "nomDepartement")
    private String nomDepartement;

    @Column(name = "nomCommune")
    private String nomCommune;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "region", allowSetters = true)
    private Regions region;

//    @ManyToOne(optional = false)
//    @NotNull
//    @JsonIgnoreProperties(value = "departement", allowSetters = true)
//    private Departements departement;
//
//    @ManyToOne(optional = false)
//    @NotNull
//    @JsonIgnoreProperties(value = "commune", allowSetters = true)
//    private Communes commune;

    public Clients() { }

    public Clients(Long id, String nom, String prenom, String codeClient, Long telephone, Long mobile, String email,
                  String nomDepartement, String nomCommunne,String adresse, Regions region/*, Departements departement, Communes commune*/) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.codeClient = codeClient;
        this.telephone = telephone;
        this.mobile = mobile;
        this.email = email;
        this.adresse = adresse;
        this.region = region;
        this.nomDepartement=  nomDepartement;
        this.nomCommune=nomCommunne;
//        this.departement= departement;
//        this.commune= commune;
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

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartemant(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    //    public Departements getDepartement() {
//        return departement;
//    }
//
//    public void setDepartement(Departements departement) {
//        this.departement = departement;
//    }
//
//    public Communes getCommune() {
//        return commune;
//    }
//
//    public void setCommune(Communes commune) {
//        this.commune = commune;
//    }

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
                ", region='" + region + '\'' +
                ", nomDepartement='" + nomDepartement + '\'' +
//                ", departement='" + departement + '\'' +
//                ", commune='" + commune + '\'' +
                '}';
    }
}
