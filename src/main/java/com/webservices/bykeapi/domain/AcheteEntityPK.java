package com.webservices.bykeapi.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class AcheteEntityPK implements Serializable {
    @Column(name = "IDVELO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvelo;
    @Column(name = "NUMUTIL")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numutil;
    @Column(name = "DATEJOUR")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date datejour;

    public int getIdvelo() {
        return idvelo;
    }

    public void setIdvelo(int idvelo) {
        this.idvelo = idvelo;
    }

    public int getNumutil() {
        return numutil;
    }

    public void setNumutil(int numutil) {
        this.numutil = numutil;
    }

    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcheteEntityPK that = (AcheteEntityPK) o;
        return idvelo == that.idvelo && numutil == that.numutil && Objects.equals(datejour, that.datejour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvelo, numutil, datejour);
    }
}
