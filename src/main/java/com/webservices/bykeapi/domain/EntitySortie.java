package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "sortie", schema = "byke", catalog = "")
public class EntitySortie {
    @Id
    @Column(name = "num_sortie")
    private int numSortie;
    @Basic
    @Column(name = "num_util")
    private int numUtil;
    @Basic
    @Column(name = "date_sortie")
    private Date dateSortie;
    @Basic
    @Column(name = "heure_depart")
    private Time heureDepart;
    @Basic
    @Column(name = "heure_arrivee")
    private Time heureArrivee;
    @Basic
    @Column(name = "lieu_depart")
    private String lieuDepart;
    @Basic
    @Column(name = "distance_parcourue")
    private BigDecimal distanceParcourue;

    public int getNumSortie() {
        return numSortie;
    }

    public void setNumSortie(int numSortie) {
        this.numSortie = numSortie;
    }

    public int getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(int numUtil) {
        this.numUtil = numUtil;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Time getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Time heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Time getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(Time heureArrivee) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntitySortie that = (EntitySortie) o;
        return numSortie == that.numSortie && numUtil == that.numUtil && Objects.equals(dateSortie, that.dateSortie) && Objects.equals(heureDepart, that.heureDepart) && Objects.equals(heureArrivee, that.heureArrivee) && Objects.equals(lieuDepart, that.lieuDepart) && Objects.equals(distanceParcourue, that.distanceParcourue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSortie, numUtil, dateSortie, heureDepart, heureArrivee, lieuDepart, distanceParcourue);
    }

    public void merge(EntitySortie sortieEntity) {
        if (sortieEntity.getNumSortie() != 0){
            this.numSortie = sortieEntity.getNumSortie();
        }
        if (sortieEntity.getNumUtil() != 0){
            this.numUtil = sortieEntity.getNumUtil();
        }
        if (sortieEntity.getDateSortie() != null){
            this.dateSortie = sortieEntity.getDateSortie();
        }
        if (sortieEntity.getHeureDepart() != null){
            this.heureDepart = sortieEntity.getHeureDepart();
        }
        if (sortieEntity.getHeureArrivee() != null){
            this.heureArrivee = sortieEntity.getHeureArrivee();
        }
        if (sortieEntity.getLieuDepart() != null){
            this.lieuDepart = sortieEntity.getLieuDepart();
        }
        if (sortieEntity.getDistanceParcourue() != null){
            this.distanceParcourue = sortieEntity.getDistanceParcourue();
        }
    }
}
