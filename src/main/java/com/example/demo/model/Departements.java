package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name ="Departements")
public class Departements implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String slug;
    private String nomDepartement;
    private Date dateCreation;



//    @ManyToOne(optional = false)
//    @NotNull
//    @JsonIgnoreProperties(value = "commune", allowSetters = true)
//    private Communes commune;
//


    @ManyToOne(fetch = FetchType.LAZY)
      private Regions region;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL/*, orphanRemoval = true*/
    )

    private Set<Communes> communes = new HashSet<Communes>(0);
    //private List<Communes> communes = new ArrayList<>();


    public Departements() {
    }

    public Departements(Long id, String slug, String nomDepartement, Date dateCreation, Communes communes) {
        this.id = id;
        this.slug = slug;
        this.nomDepartement = nomDepartement;
        this.dateCreation = dateCreation;
        this.communes = (Set<Communes>) communes;
    }

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

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Set<Communes> getCommunes() {
        return this.communes;
    }

    public void setCommunes(Set<Communes> communes) {
        this.communes = communes;
    }

    //    public Regions getRegion() {
//        return region;
//    }
//
//    public void setRegion(Regions region) {
//        this.region = region;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Departements )) return false;
//        return id != null && id.equals(((Departements) o).getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }

    @Override
    public String toString() {
        return "Departements{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", nomDepartement='" + nomDepartement + '\'' +
                ", dateCreation=" + dateCreation +
               // ", region=" + region +
                '}';
    }
}
