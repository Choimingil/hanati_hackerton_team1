package com.hanati.team1.src.players.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hanati.team1.src.players.models.GetPlayerListRes;
import com.hanati.team1.src.players.models.GetTeamListRes;
import com.hanati.team1.src.players.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TeamService {

	private final TeamRepository teamRepository;

	public List<GetTeamListRes> getTeamList(String keyword) {
		if (!StringUtils.hasText(keyword)) {
			keyword = "";
		}
		return teamRepository.findAllTeams(keyword);
	}

	public List<GetPlayerListRes> getPlayerList(long teamId) {
		return teamRepository.findAllPlayers(teamId);
	}
}
