

package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "naissance")
public class Naissance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Long id;
    private int annee;
    private Integer numeroRegistre;
    private int numeroActe;
    private String  date_declaration;
    private String  heure_declaration;
    private String  date_evenement;
    private String  heure_evenement;
    private String  pays_evenement;
    private String  temoin1;
    private String  temoin2;
    private String  temoin3;
    private String  temoin4;
    private Long  idEnfant;
    private Long  idPere;
    private Long  idMere;
    private Long  idDeclarant;

    @ManyToOne
    @JoinColumn(name ="id_formation_sanitaire")
    private FormationSanitaire  formationSanitaire;
    private Long  idTypeActe;
    private Long idTypeDeclaration;
    private Long  idDegreParent;


    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_jugement")
    private Jugement jugement;

   // private Jugement  jugement;
    private String  idSource;
    private String  numCec;
    private String  nomCec;
    private String  logicielSource;
    private String  officierEtatCivil;
    private Date dateImport;
    private Date dateImportUpdate;
    private Long batchNo;



    public Naissance(){}
    public Naissance(Long id, int annee, Integer numeroRegistre, int numeroActe, String date_declaration, String heure_declaration, String date_evenement, String heure_evenement, String pays_evenement, String temoin1, String temoin2,
                     String temoin3, String temoin4, Long idEnfant, Long idPere, Long idMere, Long idDeclarant, FormationSanitaire formationSanitaire, Long idTypeActe
            , Long idTypeDeclaration, Long idDegreParent, Jugement  jugement, String idSource,
                     String numCec, String nomCec, String logicielSource, String
                             officierEtatCivil, Date dateImport, Date dateImportUpdate, Long batchNo) {
        this.id = id;
        this.annee = annee;
        this.numeroRegistre = numeroRegistre;
        this.numeroActe = numeroActe;
        this.date_declaration = date_declaration;
        this.heure_declaration = heure_declaration;
        this.date_evenement = date_evenement;
        this.heure_evenement = heure_evenement;
        this.pays_evenement = pays_evenement;
        this.temoin1 = temoin1;
        this.temoin2 = temoin2;
        this.temoin3 = temoin3;
        this.temoin4 = temoin4;
        this.idEnfant = idEnfant;
        this.idPere = idPere;
        this.idMere = idMere;
        this.idDeclarant = idDeclarant;
        this.formationSanitaire = formationSanitaire;
        this.idTypeActe = idTypeActe;
        this.idTypeDeclaration = idTypeDeclaration;
        this.idDegreParent = idDegreParent;
        this.batchNo=batchNo;

/* this.jugement = jugement;*/

        this.jugement= jugement;
        this.idSource = idSource;
        this.numCec = numCec;
        this.nomCec = nomCec;
        this.logicielSource = logicielSource;
        this.officierEtatCivil = officierEtatCivil;
        this.dateImport = dateImport;
        this.dateImportUpdate = dateImportUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Integer getNumeroRegistre() {
        return numeroRegistre;
    }

    public void setNumeroRegistre(Integer numeroRegistre) {
        this.numeroRegistre = numeroRegistre;
    }

    public int getNumeroActe() {
        return numeroActe;
    }

    public void setNumeroActe(int numeroActe) {
        this.numeroActe = numeroActe;
    }

    public String getDate_declaration() {
        return date_declaration;
    }

    public void setDate_declaration(String date_declaration) {
        this.date_declaration = date_declaration;
    }

    public String getHeure_declaration() {
        return heure_declaration;
    }

    public void setHeure_declaration(String heure_declaration) {
        this.heure_declaration = heure_declaration;
    }

    public String getDate_evenement() {
        return date_evenement;
    }

    public void setDate_evenement(String date_evenement) {
        this.date_evenement = date_evenement;
    }

    public String getHeure_evenement() {
        return heure_evenement;
    }

    public void setHeure_evenement(String heure_evenement) {
        this.heure_evenement = heure_evenement;
    }

    public String getPays_evenement() {
        return pays_evenement;
    }

    public void setPays_evenement(String pays_evenement) {
        this.pays_evenement = pays_evenement;
    }

    public String getTemoin1() {
        return temoin1;
    }

    public void setTemoin1(String temoin1) {
        this.temoin1 = temoin1;
    }

    public String getTemoin2() {
        return temoin2;
    }

    public void setTemoin2(String temoin2) {
        this.temoin2 = temoin2;
    }

    public String getTemoin3() {
        return temoin3;
    }

    public void setTemoin3(String temoin3) {
        this.temoin3 = temoin3;
    }

    public String getTemoin4() {
        return temoin4;
    }

    public void setTemoin4(String temoin4) {
        this.temoin4 = temoin4;
    }

    public Long getIdEnfant() {
        return idEnfant;
    }

    public void setIdEnfant(Long idEnfant) {
        this.idEnfant = idEnfant;
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

    public Long getIdDeclarant() {
        return idDeclarant;
    }

    public void setIdDeclarant(Long idDeclarant) {
        this.idDeclarant = idDeclarant;
    }

    public FormationSanitaire getFormationSanitaire() {
        return formationSanitaire;
    }

    public void setFormationSanitaire(FormationSanitaire formationSanitaire) {
        this.formationSanitaire = formationSanitaire;
    }

    public Long getIdTypeActe() {
        return idTypeActe;
    }

    public void setIdTypeActe(Long idTypeActe) {
        this.idTypeActe = idTypeActe;
    }

    public Long getIdTypeDeclaration() {
        return idTypeDeclaration;
    }

    public void setIdTypeDeclaration(Long idTypeDeclaration) {
        this.idTypeDeclaration = idTypeDeclaration;
    }

    public Long getIdDegreParent() {
        return idDegreParent;
    }

    public void setIdDegreParent(Long idDegreParent) {
        this.idDegreParent = idDegreParent;
    }


/* public Jugement getJugement() {
        return jugement;
    }

    public void setJugement(Jugement jugement) {
        this.jugement = jugement;
    }


    public Jugement getJugement() {
        return jugement;
    }

    public void setJugement(Jugement jugement) {
        this.jugement = jugement;
    }
*/

    public Jugement getJugement() {
        return jugement;
    }

    public void setJugement(Jugement jugement) {
        this.jugement = jugement;
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

    public String getOfficierEtatCivil() {
        return officierEtatCivil;
    }

    public void setOfficierEtatCivil(String officierEtatCivil) {
        this.officierEtatCivil = officierEtatCivil;
    }

    public Date getDateImport() {
        return dateImport;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }

    public Date getDateImportUpdate() {
        return dateImportUpdate;
    }

    public void setDateImportUpdate(Date dateImportUpdate) {
        this.dateImportUpdate = dateImportUpdate;
    }

    public Long getbatchNo() {
        return batchNo;
    }

    public void setbatchNo(Long batchNo) {
        this.batchNo = batchNo;
    }

    @Override
    public String toString() {
        return "Naissance{" +
                "id=" + id +
                ", annee=" + annee +
                ", numeroRegistre=" + numeroRegistre +
                ", numeroActe=" + numeroActe +
                ", date_declaration='" + date_declaration + '\'' +
                ", heure_declaration='" + heure_declaration + '\'' +
                ", date_evenement='" + date_evenement + '\'' +
                ", heure_evenement='" + heure_evenement + '\'' +
                ", pays_evenement='" + pays_evenement + '\'' +
                ", temoin1='" + temoin1 + '\'' +
                ", temoin2='" + temoin2 + '\'' +
                ", temoin3='" + temoin3 + '\'' +
                ", temoin4='" + temoin4 + '\'' +
                ", idEnfant=" + idEnfant +
                ", idPere=" + idPere +
                ", idMere=" + idMere +
                ", idDeclarant=" + idDeclarant +
                ", formationSanitaire=" + formationSanitaire +
                ", idTypeActe=" + idTypeActe +
                ", idTypeDeclaration=" + idTypeDeclaration +
                ", idDegreParent=" + idDegreParent +
               // ", jugement=" + jugement +
                ", jugement=" + jugement +
                ", idSource=" + idSource +
                ", numCec='" + numCec + '\'' +
                ", nomCec='" + nomCec + '\'' +
                ", logicielSource='" + logicielSource + '\'' +
                ", officierEtatCivil='" + officierEtatCivil + '\'' +
                ", dateImport=" + dateImport +
                ", dateImportUpdate=" + dateImportUpdate +
                ", batchNo=" + batchNo +
                '}';
    }
}

