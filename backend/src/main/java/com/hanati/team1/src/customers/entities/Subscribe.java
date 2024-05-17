package com.hanati.team1.src.customers.entities;

import com.hanati.team1.src.players.entities.Player;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="Subscribe")
@ToString
@Getter
@Setter
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subscribe_id", nullable = false, insertable = false, updatable = false)
    private long subscribeId;

    @Column(name="user_id", nullable = false)
    private long userId;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", insertable = false, updatable = false, referencedColumnName="user_id")
    private User user;

    @Column(name="player_id", nullable = false)
    private long playerId;

    @ManyToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
    @JoinColumn(name="player_id", insertable = false, updatable = false, referencedColumnName="player_id")
    private Player player;

    // 100 : 구독
    // 200 : 구독 취소
    @Column(name="subscribe_status", nullable = false)
    private int subscribeStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="subscribe_date", nullable = false, insertable = false)
    private LocalDateTime subscribeDate = LocalDateTime.now();
}