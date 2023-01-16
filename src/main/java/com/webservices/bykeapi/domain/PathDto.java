package com.webservices.bykeapi.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Path} entity
 */
public class PathDto implements Serializable {
    private final Integer creatorId;
    private final String name;

    public PathDto(Integer creatorId, String name) {
        this.creatorId = creatorId;
        this.name = name;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathDto entity = (PathDto) o;
        return Objects.equals(this.creatorId, entity.creatorId) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creatorId, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "creatorId = " + creatorId + ", " +
                "name = " + name + ")";
    }
}