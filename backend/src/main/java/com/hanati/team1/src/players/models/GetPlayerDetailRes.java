package com.hanati.team1.src.players.models;

import java.time.LocalDateTime;

public record GetPlayerDetailRes(
	String profile,
	String name,
	LocalDateTime birthDay,
	String nation,
	int weight,
	int height,
	String youth,
	boolean isGoalKeeper,
	String position,
	int backNum,
	long price
) {
}
