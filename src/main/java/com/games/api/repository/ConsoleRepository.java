package com.games.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.api.entity.Console;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
}

