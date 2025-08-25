package com.games.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.api.entity.DigitalGame;

@Repository
public interface DigitalGameRepository extends JpaRepository<DigitalGame, Long> {
}

