package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "a_pour_distance", schema = "byke", catalog = "")
@IdClass(EntityAPourDistancePK.class)
public class EntityAPourDistance {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_etape_dep")
    private int idEtapeDep;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_etape_arr")
    private int idEtapeArr;
    @Basic
    @Column(name = "nbr_km")
    private BigDecimal nbrKm;

    public int getIdEtapeDep() {
        return idEtapeDep;
    }

    public void setIdEtapeDep(int idEtapeDep) {
        this.idEtapeDep = idEtapeDep;
    }

    public int getIdEtapeArr() {
        return idEtapeArr;
    }

    public void setIdEtapeArr(int idEtapeArr) {
        this.idEtapeArr = idEtapeArr;
    }

    public BigDecimal getNbrKm() {
        return nbrKm;
    }

    public void setNbrKm(BigDecimal nbrKm) {
        this.nbrKm = nbrKm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityAPourDistance that = (EntityAPourDistance) o;
        return idEtapeDep == that.idEtapeDep && idEtapeArr == that.idEtapeArr && Objects.equals(nbrKm, that.nbrKm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtapeDep, idEtapeArr, nbrKm);
    }
}
