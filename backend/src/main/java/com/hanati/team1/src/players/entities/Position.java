package com.hanati.team1.src.players.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Position")
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="position_id", nullable = false, insertable = false, updatable = false)
    private long positionId;

    @Column(name="player_id", nullable = false)
    private long playerId;

    @ManyToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
    @JoinColumn(name="player_id", insertable = false, updatable = false, referencedColumnName="player_id")
    private Player player;

    @Column(name="position_name", nullable = false)
    private String positionName;

    @Column(name="position_level", nullable = false)
    private int positionLevel;
}
