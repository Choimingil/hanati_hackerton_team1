package com.hanati.team1.src.matches.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hanati.team1.src.matches.entities.Match;
import com.hanati.team1.src.matches.models.GetMatchListRes;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {
	@Query(
		"select new com.hanati.team1.src.matches.models.GetMatchListRes(m.matchId, m.matchDate, m.playerStatus, m.playerPlaytime, m.playerScore, m.playerYcardNum) "
			+ "from Match m "
			+ "where m.playerId = :playerId "
			+ "order by m.matchDate desc")
	List<GetMatchListRes> findAllMatches(long playerId);
}
