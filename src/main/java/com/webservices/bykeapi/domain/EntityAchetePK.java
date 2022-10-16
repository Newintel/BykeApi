package com.webservices.bykeapi.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class EntityAchetePK implements Serializable {
    @Column(name = "id_velo")
    @Id
    private int idVelo;
    @Column(name = "num_util")
    @Id
    private int numUtil;
    @Column(name = "date_jour")
    @Id
    private Date dateJour;

    public int getIdVelo() {
        return idVelo;
    }

    public void setIdVelo(int idVelo) {
        this.idVelo = idVelo;
    }

    public int getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(int numUtil) {
        this.numUtil = numUtil;
    }

    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityAchetePK that = (EntityAchetePK) o;
        return idVelo == that.idVelo && numUtil == that.numUtil && Objects.equals(dateJour, that.dateJour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVelo, numUtil, dateJour);
    }
}
