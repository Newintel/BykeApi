package com.webservices.bykeapi.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EtapeEntityPK implements Serializable {
    @Column(name = "NUMETAPE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numetape;
    @Column(name = "NUMSORTIE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numsortie;

    public int getNumetape() {
        return numetape;
    }

    public void setNumetape(int numetape) {
        this.numetape = numetape;
    }

    public int getNumsortie() {
        return numsortie;
    }

    public void setNumsortie(int numsortie) {
        this.numsortie = numsortie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtapeEntityPK that = (EtapeEntityPK) o;
        return numetape == that.numetape && numsortie == that.numsortie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numetape, numsortie);
    }
}
