package com.webservices.bykeapi.domain;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PathstepId implements Serializable {
    private static final long serialVersionUID = 6180490764748444938L;
    @Column(name = "pathId", nullable = false)
    private Integer pathId;

    @Column(name = "position", nullable = false)
    private Integer position;

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PathstepId entity = (PathstepId) o;
        return Objects.equals(this.pathId, entity.pathId) &&
                Objects.equals(this.position, entity.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathId, position);
    }

}