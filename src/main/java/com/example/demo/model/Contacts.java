
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
@Entity
@Table(name ="Contacts")
public class Contacts implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String compte;
    private Long telephone;
    private Long mobile;
    private String email;
    private String ville;
    private String actif;
    private String civilite;
    private String societe;
    private String origine;
    private String type;
    private String adresse;
    private String cp;


    public Contacts(){}

    public Contacts(Long id, String nom, String prenom, String compte,Long telephone,Long mobile, String email, String ville,String actif,
                    String civilite, String societe, String origine, String type, String adresse, String cp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.compte = compte;
        this.telephone=telephone;
        this.mobile=mobile;
        this.email = email;
        this.ville = ville;
        this.actif = actif;
        this.civilite= civilite;
        this.societe=societe;
        this.origine=origine;
        this.type=type;
        this.adresse=adresse;
        this.cp=cp;
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

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }



    @Override
    public String toString() {
        return "Tableemail{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", compte='" + compte + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", ville='" + ville + '\'' +
                ", actif='" + actif + '\'' +
                "civilite='" + civilite + '\'' +
                ", societe='" + societe + '\'' +
                ", origine='" + origine + '\'' +
                ", type='" + type + '\'' +
                ", adresse='" + adresse + '\'' +
                ", cp='" + cp + '\'' +
                '}';
    }
}
