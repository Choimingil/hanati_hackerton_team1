package com.hanati.team1.src.players.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanati.team1.src.players.models.GetPlayerDetailRes;
import com.hanati.team1.src.players.models.PostTokenBuyReq;
import com.hanati.team1.src.players.models.PostTokenSellReq;
import com.hanati.team1.src.players.service.PlayerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/players")
@RestController
public class PlayerApi {

	private final PlayerService playerService;

	@GetMapping("/{player_id}")
	public GetPlayerDetailRes getPlayerDetail(@PathVariable("player_id") long playerId) {
		return playerService.getPlayerDetail(playerId);
	}

	@PostMapping("/{player_id}/buy")
	public void buyTokens(@PathVariable("player_id") long playerId, @RequestBody PostTokenBuyReq postTokenBuyReq) {
		long userId = 1L;
		playerService.buyTokens(userId, playerId, postTokenBuyReq);
	}

	@PostMapping("/{player_id}/sell")
	public void sellTokens(@PathVariable("player_id") long playerId, @RequestBody PostTokenSellReq postTokenSellReq) {
		long userId = 1L;
		playerService.sellTokens(userId, playerId, postTokenSellReq);
	}
}
