package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "byke", catalog = "")
public class UtilisateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMUTIL")
    private int numutil;
    @Basic
    @Column(name = "NOMUTI")
    private String nomuti;
    @Basic
    @Column(name = "PRENOMUTIL")
    private String prenomutil;
    @Basic
    @Column(name = "DATENAISSANCE")
    private Date datenaissance;
    @Basic
    @Column(name = "TAILLE")
    private BigDecimal taille;
    @Basic
    @Column(name = "POIDS")
    private BigDecimal poids;

    public int getNumutil() {
        return numutil;
    }

    public void setNumutil(int numutil) {
        this.numutil = numutil;
    }

    public String getNomuti() {
        return nomuti;
    }

    public void setNomuti(String nomuti) {
        this.nomuti = nomuti;
    }

    public String getPrenomutil() {
        return prenomutil;
    }

    public void setPrenomutil(String prenomutil) {
        this.prenomutil = prenomutil;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public BigDecimal getTaille() {
        return taille;
    }

    public void setTaille(BigDecimal taille) {
        this.taille = taille;
    }

    public BigDecimal getPoids() {
        return poids;
    }

    public void setPoids(BigDecimal poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return numutil == that.numutil && Objects.equals(nomuti, that.nomuti) && Objects.equals(prenomutil, that.prenomutil) && Objects.equals(datenaissance, that.datenaissance) && Objects.equals(taille, that.taille) && Objects.equals(poids, that.poids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numutil, nomuti, prenomutil, datenaissance, taille, poids);
    }
}
