package com.hanati.team1.src.players.models;

public record GetPlayerListRes(
	long id,
	int number,
	String name,
	String position,
	long price,
	String profile
) {
}
