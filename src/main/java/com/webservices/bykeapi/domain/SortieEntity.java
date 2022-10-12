package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "sortie", schema = "byke", catalog = "")
public class SortieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMSORTIE")
    private int numsortie;
    @Basic
    @Column(name = "NUMUTIL")
    private int numutil;
    @Basic
    @Column(name = "DATESORTIE")
    private Date datesortie;
    @Basic
    @Column(name = "HEUREDEPART")
    private Time heuredepart;
    @Basic
    @Column(name = "HEUREARRIVEE")
    private Time heurearrivee;
    @Basic
    @Column(name = "LIEUDEPART")
    private String lieudepart;
    @Basic
    @Column(name = "DISTANCEPARCOURUE")
    private BigDecimal distanceparcourue;

    public int getNumsortie() {
        return numsortie;
    }

    public void setNumsortie(int numsortie) {
        this.numsortie = numsortie;
    }

    public int getNumutil() {
        return numutil;
    }

    public void setNumutil(int numutil) {
        this.numutil = numutil;
    }

    public Date getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(Date datesortie) {
        this.datesortie = datesortie;
    }

    public Time getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(Time heuredepart) {
        this.heuredepart = heuredepart;
    }

    public Time getHeurearrivee() {
        return heurearrivee;
    }

    public void setHeurearrivee(Time heurearrivee) {
        this.heurearrivee = heurearrivee;
    }

    public String getLieudepart() {
        return lieudepart;
    }

    public void setLieudepart(String lieudepart) {
        this.lieudepart = lieudepart;
    }

    public BigDecimal getDistanceparcourue() {
        return distanceparcourue;
    }

    public void setDistanceparcourue(BigDecimal distanceparcourue) {
        this.distanceparcourue = distanceparcourue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortieEntity that = (SortieEntity) o;
        return numsortie == that.numsortie && numutil == that.numutil && Objects.equals(datesortie, that.datesortie) && Objects.equals(heuredepart, that.heuredepart) && Objects.equals(heurearrivee, that.heurearrivee) && Objects.equals(lieudepart, that.lieudepart) && Objects.equals(distanceparcourue, that.distanceparcourue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numsortie, numutil, datesortie, heuredepart, heurearrivee, lieudepart, distanceparcourue);
    }
}
