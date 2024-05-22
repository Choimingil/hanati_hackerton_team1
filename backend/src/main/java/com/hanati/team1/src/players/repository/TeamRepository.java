package com.hanati.team1.src.players.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hanati.team1.src.players.entities.Team;
import com.hanati.team1.src.players.models.GetPlayerListRes;
import com.hanati.team1.src.players.models.GetTeamListRes;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {
	@Query("select new com.hanati.team1.src.players.models.GetTeamListRes(t.teamId, t.teamName) "
		+ "from Team t "
		+ "where t.teamName like concat('%', :keyword, '%')")
	List<GetTeamListRes> findAllTeams(@Param("keyword") String keyword);

	@Query(
		"select new com.hanati.team1.src.players.models.GetPlayerListRes(p.playerId, tb.playerBacknum, p.playerName, (select pp.positionName from Position pp where pp.playerId = p.playerId and pp.positionLevel = 10), (select abs(tt.tokenPrice) from Trade tt where tt.playerId = p.playerId order by tt.tradeDate desc limit 1), p.playerProfile) "
			+ "from Player p "
			+ "inner join TeamByPlayer tb on tb.playerId = p.playerId and tb.endDate >= now() "
			+ "inner join Team t on t.teamId = tb.teamId "
			+ "where t.teamId = :teamId")
	List<GetPlayerListRes> findAllPlayers(@Param("teamId") long teamId);
}
