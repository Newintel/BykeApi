package com.webservices.bykeapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "sortie_etape")
public class SortieEtape {
    @EmbeddedId
    private SortieEtapeId id;

    @MapsId("numSortie")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "num_sortie", nullable = false)
    private Sortie numSortie;

    @MapsId("idEtape")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_etape", nullable = false)
    private Etape idEtape;

    public SortieEtapeId getId() {
        return id;
    }

    public void setId(SortieEtapeId id) {
        this.id = id;
    }

    public Sortie getNumSortie() {
        return numSortie;
    }

    public void setNumSortie(Sortie numSortie) {
        this.numSortie = numSortie;
    }

    public Etape getIdEtape() {
        return idEtape;
    }

    public void setIdEtape(Etape idEtape) {
        this.idEtape = idEtape;
    }

}