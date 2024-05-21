package com.hanati.team1.src.customers.entities;

import com.hanati.team1.src.players.entities.Player;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="Trade")
@Getter
@Setter
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trade_id", nullable = false)
    private long tradeId;

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

    @Column(name="token_price", nullable = false)
    private long tokenPrice;

    @Column(name="token_num", nullable = false)
    private int tokenNum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="trade_date", nullable = false)
    private LocalDateTime tradeDate = LocalDateTime.now();
}
