package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="individu")
public class Individu implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String nin;
    private String prenoms;
    private String nom;
    private String dateNaissance;
    private String lieuNaissance;
    private String sexe;
    private String profession;

    private String domicile;
    private String residence;
    private String pieceNumero;
    private Long idPere;
    private Long idMere;
    private String idSource;
    private String numCec;
    private String nomCec;
    private String logicielSource;
    private Date date_import;

    public Individu() {
    }

    public Individu(Long id, String nin, String prenoms, String nom, String dateNaissance,
                    String lieuNaissance, String sexe, String profession, String domicile, String residence, String pieceNumero, Long idPere, Long idMere, String idSource, String numCec, String nomCec, String logicielSource, Date date_import) {
        this.id = id;
        this.nin = nin;
        this.prenoms = prenoms;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.sexe = sexe;
        this.profession = profession;
        this.domicile = domicile;
        this.residence = residence;
        this.pieceNumero = pieceNumero;
        this.idPere = idPere;
        this.idMere = idMere;
        this.idSource = idSource;
        this.numCec = numCec;
        this.nomCec = nomCec;
        this.logicielSource = logicielSource;
        this.date_import = date_import;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPieceNumero() {
        return pieceNumero;
    }

    public void setPieceNumero(String pieceNumero) {
        this.pieceNumero = pieceNumero;
    }

    public Long getIdPere() {
        return idPere;
    }

    public void setIdPere(Long idPere) {
        this.idPere = idPere;
    }

    public Long getIdMere() {
        return idMere;
    }

    public void setIdMere(Long idMere) {
        this.idMere = idMere;
    }

    public String getIdSource() {
        return idSource;
    }

    public void setIdSource(String idSource) {
        this.idSource = idSource;
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

    public Date getDate_import() {
        return date_import;
    }

    public void setDate_import(Date date_import) {
        this.date_import = date_import;
    }

    @Override
    public String toString() {
        return "Individu{" +
                "id=" + id +
                ", nin='" + nin + '\'' +
                ", prenoms='" + prenoms + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                ", sexe='" + sexe + '\'' +
                ", profession='" + profession + '\'' +
                ", domicile='" + domicile + '\'' +
                ", residence='" + residence + '\'' +
                ", pieceNumero='" + pieceNumero + '\'' +
                ", idPere=" + idPere +
                ", idMere=" + idMere +
                ", idSource='" + idSource + '\'' +
                ", numCec='" + numCec + '\'' +
                ", nomCec='" + nomCec + '\'' +
                ", logicielSource='" + logicielSource + '\'' +
                ", date_import=" + date_import +
                '}';
    }
}