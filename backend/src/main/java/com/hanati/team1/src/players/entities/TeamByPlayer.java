package com.hanati.team1.src.players.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="TeamByPlayer")
@Getter
@Setter
public class TeamByPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tbp_id", nullable = false, insertable = false, updatable = false)
    private long tbpId;

    @Column(name="player_id", nullable = false)
    private long playerId;

    @ManyToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
    @JoinColumn(name="player_id", insertable = false, updatable = false, referencedColumnName="player_id")
    private Player player;

    @Column(name="team_id", nullable = false)
    private long teamId;

    @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
    @JoinColumn(name="team_id", insertable = false, updatable = false, referencedColumnName="team_id")
    private Team team;

    @Column(name="player_backnum")
    private int playerBacknum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable = false)
    private LocalDateTime startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date", nullable = false)
    private LocalDateTime endDate;
}
