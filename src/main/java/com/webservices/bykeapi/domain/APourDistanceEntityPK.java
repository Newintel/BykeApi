package com.webservices.bykeapi.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class APourDistanceEntityPK implements Serializable {
    @Column(name = "NUMSORTIE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numsortie;
    @Column(name = "NUMETAPE_DEP")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numetapeDep;
    @Column(name = "NUMETAPE_ARR")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numetapeArr;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APourDistanceEntityPK that = (APourDistanceEntityPK) o;
        return numsortie == that.numsortie && numetapeDep == that.numetapeDep && numetapeArr == that.numetapeArr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numsortie, numetapeDep, numetapeArr);
    }
}
