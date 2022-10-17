package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "vae", schema = "byke", catalog = "")
public class EntityVae {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_velo")
    private int idVelo;
    @Basic
    @Column(name = "nom_velo")
    private String nomVelo;
    @Basic
    @Column(name = "roues")
    private BigDecimal roues;
    @Basic
    @Column(name = "casette")
    private String casette;
    @Basic
    @Column(name = "puissance_moteur")
    private Integer puissanceMoteur;
    @Basic
    @Column(name = "puissance_batterie")
    private Integer puissanceBatterie;

    public int getIdVelo() {
        return idVelo;
    }

    public void setIdVelo(int idVelo) {
        this.idVelo = idVelo;
    }

    public String getNomVelo() {
        return nomVelo;
    }

    public void setNomVelo(String nomVelo) {
        this.nomVelo = nomVelo;
    }

    public BigDecimal getRoues() {
        return roues;
    }

    public void setRoues(BigDecimal roues) {
        this.roues = roues;
    }

    public String getCasette() {
        return casette;
    }

    public void setCasette(String casette) {
        this.casette = casette;
    }

    public Integer getPuissanceMoteur() {
        return puissanceMoteur;
    }

    public void setPuissanceMoteur(Integer puissanceMoteur) {
        this.puissanceMoteur = puissanceMoteur;
    }

    public Integer getPuissanceBatterie() {
        return puissanceBatterie;
    }

    public void setPuissanceBatterie(Integer puissanceBatterie) {
        this.puissanceBatterie = puissanceBatterie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityVae entityVae = (EntityVae) o;
        return idVelo == entityVae.idVelo && Objects.equals(nomVelo, entityVae.nomVelo) && Objects.equals(roues, entityVae.roues) && Objects.equals(casette, entityVae.casette) && Objects.equals(puissanceMoteur, entityVae.puissanceMoteur) && Objects.equals(puissanceBatterie, entityVae.puissanceBatterie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVelo, nomVelo, roues, casette, puissanceMoteur, puissanceBatterie);
    }
}
