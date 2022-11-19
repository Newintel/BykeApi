package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Utilisateur")
@Table(name = "utilisateur", schema = "byke")
public class Utilisateur {
    @Id
    @Column(name = "num_util", nullable = false)
    private Integer id;

    @Column(name = "nom_util", length = 20)
    private String nomUtil;

    @Column(name = "prenom_util", length = 20)
    private String prenomUtil;

    @Column(name = "mdp_util", length = 100)
    private String mdpUtil;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "taille", precision = 6, scale = 2)
    private BigDecimal taille;

    @Column(name = "poids", precision = 6, scale = 2)
    private BigDecimal poids;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMdpUtil() {
        return mdpUtil;
    }

    public void setMdpUtil(String mdpUtil) {
        this.mdpUtil = mdpUtil;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
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

}