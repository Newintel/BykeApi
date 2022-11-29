package com.webservices.bykeapi.domain;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SortieEtapeId implements Serializable {
    private static final long serialVersionUID = 8484802236943092107L;
    @Column(name = "num_sortie", nullable = false)
    private Integer numSortie;

    @Column(name = "id_etape", nullable = false)
    private Integer idEtape;

    @Column(name = "num_etape", nullable = false)
    private Integer numEtape;

    public Integer getNumSortie() {
        return numSortie;
    }

    public void setNumSortie(Integer numSortie) {
        this.numSortie = numSortie;
    }

    public Integer getIdEtape() {
        return idEtape;
    }

    public void setIdEtape(Integer idEtape) {
        this.idEtape = idEtape;
    }

    public Integer getNumEtape() {
        return numEtape;
    }

    public void setNumEtape(Integer numEtape) {
        this.numEtape = numEtape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SortieEtapeId entity = (SortieEtapeId) o;
        return Objects.equals(this.idEtape, entity.idEtape) &&
                Objects.equals(this.numSortie, entity.numSortie) &&
                Objects.equals(this.numEtape, entity.numEtape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtape, numSortie, numEtape);
    }

}