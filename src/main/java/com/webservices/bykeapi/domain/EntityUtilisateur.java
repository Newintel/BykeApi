package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "byke", catalog = "")
public class EntityUtilisateur {
    @Id
    @Column(name = "num_util")
    private int numUtil;
    @Basic
    @Column(name = "nom_util")
    private String nomUtil;
    @Basic
    @Column(name = "prenom_util")
    private String prenomUtil;
    @Basic
    @Column(name = "date_naissance")
    private Date dateNaissance;
    @Basic
    @Column(name = "taille")
    private BigDecimal taille;
    @Basic
    @Column(name = "poids")
    private BigDecimal poids;

    public int getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(int numUtil) {
        this.numUtil = numUtil;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    public String getPrenomUtil() {
        return prenomUtil;
    }

    public void setPrenomUtil(String prenomUtil) {
        this.prenomUtil = prenomUtil;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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
        EntityUtilisateur that = (EntityUtilisateur) o;
        return numUtil == that.numUtil && Objects.equals(nomUtil, that.nomUtil) && Objects.equals(prenomUtil, that.prenomUtil) && Objects.equals(dateNaissance, that.dateNaissance) && Objects.equals(taille, that.taille) && Objects.equals(poids, that.poids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numUtil, nomUtil, prenomUtil, dateNaissance, taille, poids);
    }
}
