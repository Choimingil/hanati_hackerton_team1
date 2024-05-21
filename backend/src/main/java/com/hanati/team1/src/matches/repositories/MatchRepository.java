package com.hanati.team1.src.matches.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hanati.team1.src.matches.entities.Match;
import com.hanati.team1.src.matches.models.GetMatchListRes;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {
	@Query("")
	List<GetMatchListRes> findAllMatches(long playerId);
}
