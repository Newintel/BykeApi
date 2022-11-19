package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Etape")
@Table(name = "etape", schema = "byke")
public class Etape {
    @Id
    @Column(name = "id_etape", nullable = false)
    private Integer id;

    @Column(name = "num_etape", nullable = false)
    private Integer numEtape;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "num_sortie", nullable = false)
    private Sortie numSortie;

    @Column(name = "nom_etape", length = 25)
    private String nomEtape;

    @Column(name = "latitude", precision = 16, scale = 14)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 16, scale = 14)
    private BigDecimal longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumEtape() {
        return numEtape;
    }

    public void setNumEtape(Integer numEtape) {
        this.numEtape = numEtape;
    }

    public Sortie getNumSortie() {
        return numSortie;
    }

    public void setNumSortie(Sortie numSortie) {
        this.numSortie = numSortie;
    }

    public String getNomEtape() {
        return nomEtape;
    }

    public void setNomEtape(String nomEtape) {
        this.nomEtape = nomEtape;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

}