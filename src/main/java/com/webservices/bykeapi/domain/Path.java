package com.webservices.bykeapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "path", schema = "byke")
public class Path {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "creatorId", nullable = false)
    private User creator;

    @OneToMany(mappedBy = "path")
    @JsonIgnoreProperties({"path"})
    private Set<Pathstep> pathsteps = new LinkedHashSet<>();

    @Column(name = "name", length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pathstep> getPathsteps() {
        return pathsteps;
    }

    public void setPathsteps(Set<Pathstep> pathsteps) {
        this.pathsteps = pathsteps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

}