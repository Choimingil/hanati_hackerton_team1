package com.hanati.team1.src.customers.entities;

import java.time.LocalDateTime;

import com.hanati.team1.src.players.entities.Player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Subscribe")
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

    public Subscribe() {
    }

    @Builder
    public Subscribe(long userId, long playerId) {
        this.userId = userId;
        this.playerId = playerId;
        this.subscribeStatus = 100;
    }

    public void saveSubscribe() {
        this.subscribeStatus = 100;
    }

    public void cancelSubscribe() {
        this.subscribeStatus = 200;
    }
}
