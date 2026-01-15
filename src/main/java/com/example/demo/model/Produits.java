package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="Produits")
public class Produits implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String libelle;
    private String description;
    private Long quantite;
    private String reference;
    private String type;
    private String utilisateur;
    private Date  dateCreation;
    private Double prixUnitaire;
    private Boolean produitArchive;

    private Long seuilReapprovisionnement;
    private Long stockAlerte;
//    @ManyToOne(optional = false)
//    @NotNull
//   // @JoinColumn(name ="categorie")
//    @JsonIgnoreProperties(value = "categorie", allowSetters = true)
//    private Categories  categorie;

//    @ManyToOne(optional = false)
//    @NotNull
//    @JsonIgnoreProperties(value = "categorie", allowSetters = true)
//    private Categories categorie;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "categorie", allowSetters = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categories categorie;

    @ManyToOne(optional = false)
  // @ManyToOne(cascade = {CascadeType.ALL})
    @NotNull
    @JsonIgnoreProperties(value = "fournisseurs", allowSetters = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Fournisseurs fournisseur;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "taux", allowSetters = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Taux taux;

    public Produits() { }

    public Produits(Long id, String libelle, String description, Long quantite,String reference, String type,
                    String utilisateur,Date dateCreation, Double prixUnitaire, Long seuilReapprovisionnement,
                    Long stockAlerte, Boolean produitArchive,Categories  categorie, Fournisseurs fournisseur, Taux taux) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.quantite = quantite;
        this.reference= reference;
        this.type= type;
        this.utilisateur=utilisateur;
        this.dateCreation=dateCreation;
        this.prixUnitaire = prixUnitaire;
        this.seuilReapprovisionnement = seuilReapprovisionnement;
        this.stockAlerte= stockAlerte;
        this.produitArchive=produitArchive;
        this.taux=taux;
        this.categorie=categorie;
        this.fournisseur= fournisseur;
       // this.categorie=categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Long getSeuilReapprovisionnement() {
        return seuilReapprovisionnement;
    }

    public void setSeuilReapprovisionnement(Long seuilReapprovisionnement) {
        this.seuilReapprovisionnement = seuilReapprovisionnement;
    }

    public Long getStockAlerte() {
        return stockAlerte;
    }

    public void setStockAlerte(Long stockAlerte) {
        this.stockAlerte = stockAlerte;
    }

    public Boolean getProduitArchive() {
        return produitArchive;
    }

    public void setProduitArchive(Boolean produitArchive) {
        this.produitArchive = produitArchive;
    }

    public Taux getTaux() {
        return taux;
    }

    public void setTaux(Taux taux) {
        this.taux = taux;
    }

    public Categories getCategorie() {
        return categorie;
    }

    public void setCategorie(Categories categorie) {
        this.categorie = categorie;
    }

    public Fournisseurs getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseurs fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "Produits{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", reference=" + reference +
                ", type=" + type +
                ", utilisateur=" + utilisateur +
                ", dateCreation=" + dateCreation +
                ", prixUnitaire=" + prixUnitaire +
                ", seuilReapprovisionnement=" + seuilReapprovisionnement +
                ", stockAlerte=" + stockAlerte +
                ", produitArchive=" + produitArchive +
                ", taux=" + taux +
                ", categorie=" + categorie +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
