package com.hanati.team1.src.players.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hanati.team1.src.players.entities.Player;
import com.hanati.team1.src.players.models.GetProspectRes;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	@Query(
		"select new com.hanati.team1.src.players.models.GetProspectRes(p.playerId, p.playerName, count(s.subscribeId), p.playerProfile, po.positionName) "
			+ "from Player p "
			+ "inner join Position po on po.playerId = p.playerId and po.positionLevel = 100 "
			+ "left join Subscribe s on s.player.playerId = p.playerId "
			+ "where p.playerName like concat('%', :keyword, '%') "
			+ "group by p.playerId")
	List<GetProspectRes> findAllProspects(String keyword);
}
