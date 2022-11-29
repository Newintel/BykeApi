package com.webservices.bykeapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "Sortie")
@Table(name = "sortie", schema = "byke")
public class Sortie {
    @Id
    @Column(name = "num_sortie", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "num_util", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    private Utilisateur utilisateur;

    public Integer getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(Integer numUtil) {
        this.numUtil = numUtil;
    }

    @Column(name = "num_util")
    private Integer numUtil;

    @Column(name = "date_sortie")
    private LocalDate dateSortie;

    @Column(name = "heure_depart")
    private LocalTime heureDepart;

    @Column(name = "heure_arrivee")
    private LocalTime heureArrivee;

    @Column(name = "lieu_depart", length = 30)
    private String lieuDepart;

    @Column(name = "distance_parcourue", precision = 6, scale = 2)
    private BigDecimal distanceParcourue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur numUtil) {
        this.utilisateur = numUtil;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public BigDecimal getDistanceParcourue() {
        return distanceParcourue;
    }

    public void setDistanceParcourue(BigDecimal distanceParcourue) {
        this.distanceParcourue = distanceParcourue;
    }
}