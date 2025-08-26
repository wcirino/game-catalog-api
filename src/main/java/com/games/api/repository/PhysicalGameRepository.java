package com.games.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.games.api.entity.PhysicalGame;

@Repository
public interface PhysicalGameRepository extends JpaRepository<PhysicalGame, Long>,JpaSpecificationExecutor<PhysicalGame> {
}
