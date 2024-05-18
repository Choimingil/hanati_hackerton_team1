package com.hanati.team1.src.players.models;

import java.time.LocalDateTime;

public record GetProspectDetailRes(
	String profile,
	String name,
	LocalDateTime birthDate,
	String nation,
	int weight,
	int height,
	String vision,
	String effort,
	String advantage,
	String video,
	String position,
	boolean isSubscribed,
	String youth
) {
}
