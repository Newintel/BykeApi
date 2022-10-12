package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "achete", schema = "byke", catalog = "")
@IdClass(AcheteEntityPK.class)
public class AcheteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVELO")
    private int idvelo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMUTIL")
    private int numutil;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DATEJOUR")
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
        AcheteEntity that = (AcheteEntity) o;
        return idvelo == that.idvelo && numutil == that.numutil && Objects.equals(datejour, that.datejour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvelo, numutil, datejour);
    }
}
