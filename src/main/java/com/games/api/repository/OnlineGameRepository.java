package com.games.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.api.entity.OnlineGame;

@Repository
public interface OnlineGameRepository extends JpaRepository<OnlineGame, Long> {
}
