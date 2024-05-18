package com.hanati.team1.src.players.models;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import com.hanati.team1.src.players.entities.Player;

public record PostProspectReq(
	MultipartFile profile,
	String name,
	LocalDateTime birthDate,
	String nation,
	int weight,
	int height,
	String vision,
	String effort,
	String advantage,
	MultipartFile video,
	String youth
) {
	public Player toEntity(String profile, String video) {
		return Player.builder()
			.playerName(this.name())
			.playerNation(this.nation())
			.playerBirth(this.birthDate())
			.playerHeight(this.height())
			.playerWeight(this.weight())
			.playerStatus(200)
			.playerVision(this.vision())
			.playerEffort(this.effort())
			.playerAdvantage(this.advantage())
			.playerProfile(profile)
			.playerVideo(video)
			.playerYouth(this.youth())
			.build();
	}
}
