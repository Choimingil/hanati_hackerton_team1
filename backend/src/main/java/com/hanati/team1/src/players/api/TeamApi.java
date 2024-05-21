package com.hanati.team1.src.players.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanati.team1.src.players.models.GetPlayerListRes;
import com.hanati.team1.src.players.models.GetTeamListRes;
import com.hanati.team1.src.players.service.TeamService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/teams")
@RestController
public class TeamApi {

	private final TeamService teamService;

	@GetMapping
	public Map<String, List<GetTeamListRes>> getTeamList(@RequestParam("keyword") String keyword) {
		List<GetTeamListRes> teamList = teamService.getTeamList(keyword);
		return Map.of("data", teamList);
	}

	@GetMapping("/{team_id}")
	public Map<String, List<GetPlayerListRes>> getPlayerList(@PathVariable("team_id") long teamId) {
		List<GetPlayerListRes> playerList = teamService.getPlayerList(teamId);
		return Map.of("data", playerList);
	}
}
