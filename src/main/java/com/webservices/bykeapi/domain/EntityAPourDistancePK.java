package com.webservices.bykeapi.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EntityAPourDistancePK implements Serializable {
    @Column(name = "id_etape_dep")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idEtapeDep;
    @Column(name = "id_etape_arr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idEtapeArr;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityAPourDistancePK that = (EntityAPourDistancePK) o;
        return idEtapeDep == that.idEtapeDep && idEtapeArr == that.idEtapeArr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtapeDep, idEtapeArr);
    }
}
