package com.hanati.team1.src.matches.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="GoalKeeperRecord")
@Getter
@Setter
public class GoalKeeperRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="record_id", nullable = false, insertable = false, updatable = false)
    private long recordId;

    @Column(name="match_id", nullable = false)
    private long matchId;

    @OneToOne(targetEntity = Match.class, fetch = FetchType.LAZY)
    @JoinColumn(name="match_id", insertable = false, updatable = false, referencedColumnName="match_id")
    private Match match;

    @Column(name="conceded_num", nullable = false)
    private int concededNum;

    @Column(name="save_num", nullable = false)
    private int saveNum;
}
