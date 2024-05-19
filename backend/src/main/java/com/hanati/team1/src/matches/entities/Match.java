package com.hanati.team1.src.matches.entities;

import com.hanati.team1.src.players.entities.Player;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="MatchTbl")
@Getter
@Setter
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="match_id", nullable = false, insertable = false, updatable = false)
    private long matchId;

    @Column(name="player_id", nullable = false)
    private long playerId;

    @ManyToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
    @JoinColumn(name="player_id", insertable = false, updatable = false, referencedColumnName="player_id")
    private Player player;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="match_date", nullable = false)
    private LocalDateTime matchDate;

    // 두 자리 정수
    // 앞 자리 : (1 = 선발, 2 = 교체)
    // 뒤 자리 : (2 = MVP, 1 : 특징 없음, 0 : 퇴장)
    @Column(name="player_status", nullable = false)
    private int playerStatus;

    @Column(name="player_playtime", nullable = false)
    private int playerPlaytime;

    @Column(name="player_score", nullable = false)
    private double playerScore;

    @Column(name="player_ycard_num", nullable = false)
    private int playerYcardNum;
}
