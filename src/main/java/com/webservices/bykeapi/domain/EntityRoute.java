package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "route", schema = "byke", catalog = "")
public class EntityRoute {
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
    @Column(name = "type_cadre")
    private String typeCadre;

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

    public String getTypeCadre() {
        return typeCadre;
    }

    public void setTypeCadre(String typeCadre) {
        this.typeCadre = typeCadre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityRoute that = (EntityRoute) o;
        return idVelo == that.idVelo && Objects.equals(nomVelo, that.nomVelo) && Objects.equals(roues, that.roues) && Objects.equals(casette, that.casette) && Objects.equals(typeCadre, that.typeCadre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVelo, nomVelo, roues, casette, typeCadre);
    }
}
