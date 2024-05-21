package com.hanati.team1.src.players.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanati.team1.src.players.models.GetPlayerDetailRes;
import com.hanati.team1.src.players.service.PlayerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/players")
@RestController
public class PlayerApi {

	private final PlayerService playerService;

	@GetMapping("/{player_id}")
	public GetPlayerDetailRes getPlayerDetail(@PathVariable("player_id") long playerId) {
		return playerService.getPlayerDetail(playerId);
	}
}
