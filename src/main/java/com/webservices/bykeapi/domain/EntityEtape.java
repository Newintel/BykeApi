package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "etape", schema = "byke", catalog = "")
public class EntityEtape {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_etape")
    private int idEtape;
    @Basic
    @Column(name = "num_etape")
    private int numEtape;
    @Basic
    @Column(name = "num_sortie")
    private int numSortie;
    @Basic
    @Column(name = "nom_etape")
    private String nomEtape;
    @Basic
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Basic
    @Column(name = "longitude")
    private BigDecimal longitude;

    public int getIdEtape() {
        return idEtape;
    }

    public void setIdEtape(int idEtape) {
        this.idEtape = idEtape;
    }

    public int getNumEtape() {
        return numEtape;
    }

    public void setNumEtape(int numEtape) {
        this.numEtape = numEtape;
    }

    public int getNumSortie() {
        return numSortie;
    }

    public void setNumSortie(int numSortie) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityEtape that = (EntityEtape) o;
        return idEtape == that.idEtape && numEtape == that.numEtape && numSortie == that.numSortie && Objects.equals(nomEtape, that.nomEtape) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtape, numEtape, numSortie, nomEtape, latitude, longitude);
    }
}
