package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "vtt", schema = "byke", catalog = "")
public class VttEntity {
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
        VttEntity vttEntity = (VttEntity) o;
        return idvelo == vttEntity.idvelo && Objects.equals(nomvelo, vttEntity.nomvelo) && Objects.equals(roues, vttEntity.roues) && Objects.equals(cassette, vttEntity.cassette);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvelo, nomvelo, roues, cassette);
    }
}
