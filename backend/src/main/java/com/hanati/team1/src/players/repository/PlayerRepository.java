package com.hanati.team1.src.players.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hanati.team1.src.players.entities.Player;
import com.hanati.team1.src.players.models.GetProspectRes;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	@Query("")
	List<GetProspectRes> findAllProspects();
}
