package com.webservices.bykeapi.domain;

import javax.persistence.*;

@Entity(name = "Achete")
@Table(name = "achete", schema = "byke")
public class Achete {
    @EmbeddedId
    private AcheteId id;

    @MapsId("idVelo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_velo", nullable = false)
    private Velo idVelo;

    public AcheteId getId() {
        return id;
    }

    public void setId(AcheteId id) {
        this.id = id;
    }

    public Velo getIdVelo() {
        return idVelo;
    }

    public void setIdVelo(Velo idVelo) {
        this.idVelo = idVelo;
    }

}