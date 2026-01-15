
package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name ="jugement")


public class Jugement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String numeroJugement;
    private String dateJugement;
    private String dateTranscription;
    private String lieuJugement;
    private String numCec;
    private String nomCec;
    private String logicielSource;
    private Date dateImport;



    public Jugement(){}
    public Jugement(Long id, String numeroJugement, String dateJugement, String dateTranscription,
                    String lieuJugement, String numCec, String nomCec, String logicielSource, Date dateImport) {
        this.id = id;
        this.numeroJugement = numeroJugement;
        this.dateJugement = dateJugement;
        this.dateTranscription = dateTranscription;
        this.lieuJugement = lieuJugement;
        this.numCec = numCec;
        this.nomCec = nomCec;
        this.logicielSource = logicielSource;
        this.dateImport = dateImport;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroJugement() {
        return numeroJugement;
    }

    public void setNumeroJugement(String numeroJugement) {
        this.numeroJugement = numeroJugement;
    }

    public String getDateJugement() {
        return dateJugement;
    }

    public void setDateJugement(String dateJugement) {
        this.dateJugement = dateJugement;
    }

    public String getDateTranscription() {
        return dateTranscription;
    }

    public void setDateTranscription(String dateTranscription) {
        this.dateTranscription = dateTranscription;
    }

    public String getLieuJugement() {
        return lieuJugement;
    }

    public void setLieuJugement(String lieuJugement) {
        this.lieuJugement = lieuJugement;
    }

    public String getNumCec() {
        return numCec;
    }

    public void setNumCec(String numCec) {
        this.numCec = numCec;
    }

    public String getNomCec() {
        return nomCec;
    }

    public void setNomCec(String nomCec) {
        this.nomCec = nomCec;
    }

    public String getLogicielSource() {
        return logicielSource;
    }

    public void setLogicielSource(String logicielSource) {
        this.logicielSource = logicielSource;
    }

    public Date getDateImport() {
        return dateImport;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }


    @Override
    public String toString() {
        return "Jugement{" +
                "id=" + id +
                ", numeroJugement='" + numeroJugement + '\'' +
                ", dateJugement='" + dateJugement + '\'' +
                ", dateTranscription='" + dateTranscription + '\'' +
                ", lieuJugement='" + lieuJugement + '\'' +
                ", numCec='" + numCec + '\'' +
                ", nomCec='" + nomCec + '\'' +
                ", logicielSource='" + logicielSource + '\'' +
                ", dateImport=" + dateImport +
                '}';
    }
}

