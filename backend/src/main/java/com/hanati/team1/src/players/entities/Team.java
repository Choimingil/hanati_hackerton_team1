package com.hanati.team1.src.players.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Team")
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id", nullable = false, insertable = false, updatable = false)
    private long teamId;

    @Column(name="team_name", nullable = false)
    private String teamName;

    @Column(name="team_nation", nullable = false)
    private String teamNation;
}
