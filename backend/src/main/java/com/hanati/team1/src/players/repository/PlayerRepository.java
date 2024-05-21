package com.hanati.team1.src.players.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hanati.team1.src.players.entities.Player;
import com.hanati.team1.src.players.models.GetPlayerDetailRes;
import com.hanati.team1.src.players.models.GetProspectDetailRes;
import com.hanati.team1.src.players.models.GetProspectRes;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	@Query(
		"select new com.hanati.team1.src.players.models.GetProspectRes(p.playerId, p.playerName, (select count(s.subscribeId) from Subscribe s where s.playerId = p.playerId and s.subscribeStatus = 100), p.playerProfile, po.positionName) "
			+ "from Player p "
			+ "inner join Position po on po.playerId = p.playerId "
			+ "where p.playerName like concat('%', :keyword, '%') and p.playerStatus = 200")
	List<GetProspectRes> findAllProspects(String keyword);

	@Query(
		"select new com.hanati.team1.src.players.models.GetProspectDetailRes(p.playerProfile, p.playerName, p.playerBirth, p.playerNation, p.playerWeight, p.playerHeight, p.playerVision, p.playerEffort, p.playerAdvantage, p.playerVideo, po.positionName, case when (select count(s.subscribeId) from Subscribe s where s.playerId = p.playerId and s.subscribeStatus = 100 and s.userId = :userId) > 0 then true else false end, p.playerYouth) "
			+ "from Player p "
			+ "inner join Position po on po.playerId = p.playerId "
			+ "where p.playerId = :prospectId")
	Optional<GetProspectDetailRes> findProspectById(long prospectId, long userId);

	@Query(
		"select new com.hanati.team1.src.players.models.GetPlayerDetailRes(p.playerProfile, p.playerName, p.playerBirth, p.playerNation, p.playerWeight, p.playerHeight, p.playerYouth, case when pp.positionName = 'GK' then true else false end) "
			+ "from Player p "
			+ "inner join Position pp on pp.playerId = p.playerId "
			+ "where p.playerId = :playerId")
	Optional<GetPlayerDetailRes> findPlayerById(long playerId);
}
