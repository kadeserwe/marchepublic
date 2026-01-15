package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="Regions")
public class Regions implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue
        private Long id;
        private String slug;
        private String nomRegion;
        private Date dateCreation;



//        @ManyToOne(optional = false)
//        @NotNull
//        @JsonIgnoreProperties(value = "departement", allowSetters = true)
      //  private Departements  departement;

    @OneToMany(
            mappedBy = "region",
            cascade = CascadeType.ALL
            //cascade = CascadeType.ALL,
            //orphanRemoval = true
    )

    private List<Departements> departements = new ArrayList<>();



    public Regions() {
    }

    public Regions(Long id, String slug, String nomRegion, Date dateCreation, Departements departements) {
        this.id = id;
        this.slug = slug;
        this.nomRegion = nomRegion;
        this.dateCreation = dateCreation;
        this.departements = (List<Departements>) departements;
    }


//    public void Departement(Departements departement) {
//        departements.add(departement);
//        departement.setRegion(this);
//    }
//
//    public void removeDepartement(Departements departement) {
//        departements.remove(departement);
//        departement.setRegion(null);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Departements> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departements> departements) {
        this.departements = departements;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", nomRegion='" + nomRegion + '\'' +
                ", dateCreation=" + dateCreation +
                ", departements=" + departements +
                '}';
    }
}
