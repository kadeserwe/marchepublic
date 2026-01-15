package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="Communes")
public class Communes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String slug;
    private String nomCommune;
    private Date dateCreation;

//    @Transient
//    private String nomDepartement;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JsonBackReference
   // @JoinColumn(name = "communes")
    private Departements departement;


    public Communes() {
    }

    public Communes(Long id, String slug, String nomCommune, Date dateCreation, /*String nomDepartement,*/ Departements departement) {
        this.id = id;
        this.slug = slug;
        this.nomCommune = nomCommune;
        this.dateCreation = dateCreation;
        this.departement= departement;
       // this.nomDepartement= nomDepartement;
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

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Departements getDepartement() {
        return departement;
    }



    public void setDepartement(Departements departement) {
        this.departement = departement;
    }

//    public String getNomDepartement() {
//        return getDepartement().getNomDepartement();
//    }
//
//    public void setNomDepartement(String nomDepartement) {
//        this.nomDepartement = nomDepartement;
//    }


    //
//    public void setDepartement(Departements departement) {
//        this.departement = departement;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Communes )) return false;
//        return id != null && id.equals(((Communes) o).getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }

    @Override
    public String toString() {
        return "Communes{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", nomCommune='" + nomCommune + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
