package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "a_pour_distance", schema = "byke", catalog = "")
@IdClass(APourDistanceEntityPK.class)
public class APourDistanceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMSORTIE")
    private int numsortie;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMETAPE_DEP")
    private int numetapeDep;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMETAPE_ARR")
    private int numetapeArr;
    @Basic
    @Column(name = "NOMBREKM")
    private BigDecimal nombrekm;

    public int getNumsortie() {
        return numsortie;
    }

    public void setNumsortie(int numsortie) {
        this.numsortie = numsortie;
    }

    public int getNumetapeDep() {
        return numetapeDep;
    }

    public void setNumetapeDep(int numetapeDep) {
        this.numetapeDep = numetapeDep;
    }

    public int getNumetapeArr() {
        return numetapeArr;
    }

    public void setNumetapeArr(int numetapeArr) {
        this.numetapeArr = numetapeArr;
    }

    public BigDecimal getNombrekm() {
        return nombrekm;
    }

    public void setNombrekm(BigDecimal nombrekm) {
        this.nombrekm = nombrekm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APourDistanceEntity that = (APourDistanceEntity) o;
        return numsortie == that.numsortie && numetapeDep == that.numetapeDep && numetapeArr == that.numetapeArr && Objects.equals(nombrekm, that.nombrekm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numsortie, numetapeDep, numetapeArr, nombrekm);
    }
}
