package com.hanati.team1.src.players.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hanati.team1.src.players.entities.Player;
import com.hanati.team1.src.players.models.GetProspectRes;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	@Query(
		"select new com.hanati.team1.src.players.models.GetProspectRes(p.playerId, p.playerName, (select count(s.subscribeId) from Subscribe s where s.playerId = p.playerId and s.subscribeStatus = 100), p.playerProfile, po.positionName) "
			+ "from Player p "
			+ "inner join Position po on po.playerId = p.playerId and po.positionLevel = 100 "
			+ "where p.playerName like concat('%', :keyword, '%') and p.playerStatus = 200")
	List<GetProspectRes> findAllProspects(String keyword);
}
