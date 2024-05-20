package com.hanati.team1.src.players.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hanati.team1.src.players.entities.Team;
import com.hanati.team1.src.players.models.GetPlayerListRes;
import com.hanati.team1.src.players.models.GetTeamListRes;

public interface TeamRepository extends JpaRepository<Team, Long> {
	@Query("select new com.hanati.team1.src.players.models.GetTeamListRes(t.teamId, t.teamName) "
		+ "from Team t "
		+ "where t.teamName like concat('%', :keyword, '%')")
	List<GetTeamListRes> findAllTeams(String keyword);

	@Query(
		"select new com.hanati.team1.src.players.models.GetPlayerListRes(p.playerId, tb.playerBacknum, p.playerName, pp.positionName, tt.tokenPrice, 'profile') "
			+ "from Player p "
			+ "inner join TeamByPlayer tb on tb.playerId = p.playerId and tb.endDate >= now()"
			+ "inner join Team t on t.teamId = tb.teamId "
			+ "inner join Position pp on pp.playerId = p.playerId "
			+ "inner join Trade tt on tt.playerId = p.playerId "
			+ "where t.teamId = :teamId")
	List<GetPlayerListRes> findAllPlayers(long teamId);
}
