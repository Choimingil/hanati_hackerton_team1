package com.hanati.team1.src.players.models;

import java.time.LocalDateTime;

import com.hanati.team1.src.customers.entities.Trade;

public record PostTokenBuyReq(
	long tokenPrice,
	int tokenCount
) {
	public Trade toEntity(long userId, long playerId) {
		return Trade.builder()
			.userId(userId)
			.playerId(playerId)
			.tokenPrice(-this.tokenPrice)
			.tokenNum(this.tokenCount)
			.tradeDate(LocalDateTime.now())
			.build();
	}
}
