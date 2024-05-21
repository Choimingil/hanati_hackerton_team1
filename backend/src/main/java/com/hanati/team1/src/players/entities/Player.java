package com.hanati.team1.src.players.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Player")
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="player_id", nullable = false, insertable = false, updatable = false)
    private long playerId;

    @Column(name="player_name", nullable = false)
    private String playerName;

    @Column(name="player_nation", nullable = false)
    private String playerNation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="player_birth", nullable = false)
    private LocalDateTime playerBirth;

    @Column(name="player_height", nullable = false)
    private int playerHeight;

    @Column(name="player_weight", nullable = false)
    private int playerWeight;

    @Column(name="player_profile", nullable = false)
    private String playerProfile;

    @Column(name = "player_youth", nullable = false)
    private String playerYouth;

    // 100 : 프로
    // 200 : 유망주
    @Column(name="player_status", nullable = false)
    private int playerStatus;

    @Column(name="player_vision")
    private String playerVision;

    @Column(name="player_effort")
    private String playerEffort;

    @Column(name="player_advantage")
    private String playerAdvantage;

    @Column(name="player_video")
    private String playerVideo;

    @Builder
    public Player(String playerName, String playerNation, LocalDateTime playerBirth, int playerHeight,
        int playerWeight,
        int playerStatus, String playerVision, String playerEffort, String playerAdvantage, String playerProfile,
        String playerVideo, String playerYouth) {
        this.playerName = playerName;
        this.playerNation = playerNation;
        this.playerBirth = playerBirth;
        this.playerHeight = playerHeight;
        this.playerWeight = playerWeight;
        this.playerStatus = playerStatus;
        this.playerVision = playerVision;
        this.playerEffort = playerEffort;
        this.playerAdvantage = playerAdvantage;
        this.playerProfile = playerProfile;
        this.playerVideo = playerVideo;
        this.playerYouth = playerYouth;
    }

    public Player() {
    }
}
