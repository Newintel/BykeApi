package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Pathstep;
import com.webservices.bykeapi.domain.PathstepId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PathstepRepository extends JpaRepository<Pathstep, PathstepId> {
    @Transactional
    @Modifying
    @Query("update Pathstep ps set ps.id.position = ps.id.position + ?3 where ps.id.pathId = ?1 and ps.id.position >= ?2")
    void modifyPositionFrom(int pathId, int position, int increment);

    @Transactional
    @Modifying
    @Query("delete from Pathstep ps where ps.id.pathId = ?1")
    void deleteByPathId(int pathId);
}