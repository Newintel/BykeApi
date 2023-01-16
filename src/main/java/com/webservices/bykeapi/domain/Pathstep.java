package com.webservices.bykeapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "pathStep", schema = "byke")
public class Pathstep {
    @EmbeddedId
    private PathstepId id;

    @MapsId("pathId")
    @ManyToOne
    @JoinColumn(name = "pathId", nullable = false)
    private Path path;

    @ManyToOne
    @JoinColumn(name = "stepId", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Step step;

    public PathstepId getId() {
        return id;
    }

    public void setId(PathstepId id) {
        this.id = id;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

}