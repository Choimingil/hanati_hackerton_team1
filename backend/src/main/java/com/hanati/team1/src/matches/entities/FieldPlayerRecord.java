package com.hanati.team1.src.matches.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="FieldPlayerRecord")
@Getter
@Setter
public class FieldPlayerRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="record_id", nullable = false, insertable = false, updatable = false)
    private long recordId;

    @Column(name="match_id", nullable = false)
    private long matchId;

    @OneToOne(targetEntity = Match.class, fetch = FetchType.LAZY)
    @JoinColumn(name="match_id", insertable = false, updatable = false, referencedColumnName="match_id")
    private Match match;

    @Column(name="goal_num", nullable = false)
    private int goalNum;

    @Column(name="shoot_num", nullable = false)
    private int shootNum;

    @Column(name="effective_shoot_num", nullable = false)
    private int effectiveShootNum;

    @Column(name="assist_num", nullable = false)
    private int assistNum;

    @Column(name="chance_create_num", nullable = false)
    private int chanceCreateNum;

    @Column(name="pass_win_num", nullable = false)
    private int passWinNum;

    @Column(name="pass_loss_num", nullable = false)
    private int passLossNum;

    @Column(name="tackle_win_num", nullable = false)
    private int tackleWinNum;

    @Column(name="tackle_loss_num", nullable = false)
    private int tackleLossNum;

    @Column(name="header_win_num", nullable = false)
    private int headerWinNum;

    @Column(name="header_loss_num", nullable = false)
    private int headerLossNum;
}
