package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "etape", schema = "byke", catalog = "")
@IdClass(EtapeEntityPK.class)
public class EtapeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMETAPE")
    private int numetape;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMSORTIE")
    private int numsortie;
    @Basic
    @Column(name = "NOMETAPE")
    private String nometape;
    @Basic
    @Column(name = "LATITUDE")
    private BigDecimal latitude;
    @Basic
    @Column(name = "LONGITUDE")
    private BigDecimal longitude;

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

    public String getNometape() {
        return nometape;
    }

    public void setNometape(String nometape) {
        this.nometape = nometape;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtapeEntity that = (EtapeEntity) o;
        return numetape == that.numetape && numsortie == that.numsortie && Objects.equals(nometape, that.nometape) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numetape, numsortie, nometape, latitude, longitude);
    }
}
