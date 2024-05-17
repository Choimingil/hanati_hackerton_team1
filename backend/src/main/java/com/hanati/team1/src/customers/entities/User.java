package com.hanati.team1.src.customers.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="User")
@ToString
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false, insertable = false, updatable = false)
    private long userId;

    @Column(name="user_name", nullable = false)
    private String userName;

    @Column(name="user_profile", nullable = false)
    private String userProfile;
}
