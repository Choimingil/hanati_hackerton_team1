package com.hanati.team1.src.matches.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hanati.team1.src.matches.models.GetMatchListRes;
import com.hanati.team1.src.matches.service.MatchService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MatchApi {

	private final MatchService matchService;

	@GetMapping("/players/{player_id}/matches")
	public Map<String, List<GetMatchListRes>> getMatchList(@PathVariable("player_id") long playerId) {
		List<GetMatchListRes> matchList = matchService.getMatchList(playerId);
		return Map.of("data", matchList);
	}
}
