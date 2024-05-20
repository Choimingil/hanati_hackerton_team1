package com.hanati.team1.src.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanati.team1.src.players.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
