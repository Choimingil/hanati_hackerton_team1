package com.hanati.team1.src.players.models;

public record GetProspectRes(
	long id,
	String name,
	int cntSub,
	String profile,
	String position
) {
}
