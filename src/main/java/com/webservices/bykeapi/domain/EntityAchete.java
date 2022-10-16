package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "achete", schema = "byke", catalog = "")
@IdClass(EntityAchetePK.class)
public class EntityAchete {
    @Id
    @Column(name = "id_velo")
    private int idVelo;
    @Id
    @Column(name = "num_util")
    private int numUtil;
    @Id
    @Column(name = "date_jour")
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
        EntityAchete that = (EntityAchete) o;
        return idVelo == that.idVelo && numUtil == that.numUtil && Objects.equals(dateJour, that.dateJour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVelo, numUtil, dateJour);
    }
}
