package com.hanati.team1.src.players.repository;

import com.hanati.team1.src.players.entities.TeamByPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamByPlayerRepository extends JpaRepository<TeamByPlayer,Long> {
}
