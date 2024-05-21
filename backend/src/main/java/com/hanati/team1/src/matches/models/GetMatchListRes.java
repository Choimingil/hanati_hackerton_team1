package com.hanati.team1.src.matches.models;

import java.time.LocalDateTime;

public record GetMatchListRes(
	long id,
	LocalDateTime date,
	int playerStatus,
	int playTime,
	double score,
	int yCardNum
) {
}
