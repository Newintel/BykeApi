package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "vae", schema = "byke", catalog = "")
public class VaeEntity {
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
    @Basic
    @Column(name = "PUISSANCEMOTEUR")
    private Integer puissancemoteur;
    @Basic
    @Column(name = "PUISSANCEBATTERIE")
    private Integer puissancebatterie;

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

    public Integer getPuissancemoteur() {
        return puissancemoteur;
    }

    public void setPuissancemoteur(Integer puissancemoteur) {
        this.puissancemoteur = puissancemoteur;
    }

    public Integer getPuissancebatterie() {
        return puissancebatterie;
    }

    public void setPuissancebatterie(Integer puissancebatterie) {
        this.puissancebatterie = puissancebatterie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaeEntity vaeEntity = (VaeEntity) o;
        return idvelo == vaeEntity.idvelo && Objects.equals(nomvelo, vaeEntity.nomvelo) && Objects.equals(roues, vaeEntity.roues) && Objects.equals(cassette, vaeEntity.cassette) && Objects.equals(puissancemoteur, vaeEntity.puissancemoteur) && Objects.equals(puissancebatterie, vaeEntity.puissancebatterie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvelo, nomvelo, roues, cassette, puissancemoteur, puissancebatterie);
    }
}
