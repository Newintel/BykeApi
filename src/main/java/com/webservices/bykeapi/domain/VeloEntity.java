package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "velo", schema = "byke", catalog = "")
public class VeloEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVELO")
    private int idvelo;
    @Basic
    @Column(name = "NOMVELO")
    private String nomvelo;
    @Basic
    @Column(name = "ROUES")
    private BigDecimal roues;
    @Basic
    @Column(name = "CASSETTE")
    private String cassette;

    public int getIdvelo() {
        return idvelo;
    }

    public void setIdvelo(int idvelo) {
        this.idvelo = idvelo;
    }

    public String getNomvelo() {
        return nomvelo;
    }

    public void setNomvelo(String nomvelo) {
        this.nomvelo = nomvelo;
    }

    public BigDecimal getRoues() {
        return roues;
    }

    public void setRoues(BigDecimal roues) {
        this.roues = roues;
    }

    public String getCassette() {
        return cassette;
    }

    public void setCassette(String cassette) {
        this.cassette = cassette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeloEntity that = (VeloEntity) o;
        return idvelo == that.idvelo && Objects.equals(nomvelo, that.nomvelo) && Objects.equals(roues, that.roues) && Objects.equals(cassette, that.cassette);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvelo, nomvelo, roues, cassette);
    }
}
