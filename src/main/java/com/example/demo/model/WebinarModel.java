package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "webinar")
public class WebinarModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
   // @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String libelle;
    private String description;
    private Date DateCreation;
    private String url;
    private Date dateHeure;
    private int isDeleted;
    private String urlMouvement;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "imageId", allowSetters = true)
    private Categories imageId;

    public WebinarModel(){}

    public WebinarModel(int id, String libelle, String description, Date dateCreation, String url, Date dateHeure, int isDeleted, Categories imageId, String urlMouvement) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        DateCreation = dateCreation;
        this.url = url;
        this.dateHeure = dateHeure;
        this.isDeleted = isDeleted;
        this.imageId=imageId;
        this.urlMouvement=urlMouvement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DateCreation", length = 7)
    public Date getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        DateCreation = dateCreation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }


    public Categories getImageId() {
        return imageId;
    }

    public void setImageId(Categories imageId) {
        this.imageId = imageId;
    }


    public String getUrlMouvement() {
        return urlMouvement;
    }

    public void setUrlMouvement(String urlMouvement) {
        this.urlMouvement = urlMouvement;
    }

    @Override
    public String toString() {
        return "WebinarModel{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", DateCreation=" + DateCreation +
                ", url='" + url + '\'' +
                ", dateHeure=" + dateHeure +
                ", isDeleted=" + isDeleted +
                // ", imageId=" + imageId +
                '}';
    }
}
