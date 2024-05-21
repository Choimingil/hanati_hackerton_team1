package com.hanati.team1.src.matches.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanati.team1.src.matches.models.GetMatchListRes;
import com.hanati.team1.src.matches.repositories.MatchRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MatchService {

	private final MatchRepository matchRepository;

	public List<GetMatchListRes> getMatchList(long playerId) {
		return matchRepository.findAllMatches(playerId);
	}
}
