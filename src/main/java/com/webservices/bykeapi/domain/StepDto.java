package com.webservices.bykeapi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link Step} entity
 */
public class StepDto implements Serializable {
    private String location;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Integer creatorId;

    public StepDto() {
    }

    public StepDto(String location, BigDecimal latitude, BigDecimal longitude, Integer creatorId) {
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.creatorId = creatorId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepDto entity = (StepDto) o;
        return Objects.equals(this.location, entity.location) &&
                Objects.equals(this.latitude, entity.latitude) &&
                Objects.equals(this.longitude, entity.longitude) &&
                Objects.equals(this.creatorId, entity.creatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, latitude, longitude, creatorId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "location = " + location + ", " +
                "latitude = " + latitude + ", " +
                "longitude = " + longitude + ", " +
                "creatorId = " + creatorId + ")";
    }
}