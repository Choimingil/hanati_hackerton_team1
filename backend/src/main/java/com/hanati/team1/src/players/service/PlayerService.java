package com.hanati.team1.src.players.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanati.team1.src.customers.entities.Trade;
import com.hanati.team1.src.customers.repository.TradeRepository;
import com.hanati.team1.src.players.models.GetPlayerDetailRes;
import com.hanati.team1.src.players.models.PostTokenBuyReq;
import com.hanati.team1.src.players.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PlayerService {

	private final PlayerRepository playerRepository;
	private final TradeRepository tradeRepository;

	public GetPlayerDetailRes getPlayerDetail(long playerId) {
		return playerRepository.findPlayerById(playerId)
			.orElseThrow(() -> new IllegalArgumentException("잘못된 요청입니다."));
	}

	@Transactional
	public void buyTokens(long userId, long playerId, PostTokenBuyReq postTokenBuyReq) {
		Trade trade = postTokenBuyReq.toEntity(userId, playerId);
		tradeRepository.save(trade);
	}
}
