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

	@Query("")
	List<GetPlayerListRes> findAllPlayers(long teamId);
}
