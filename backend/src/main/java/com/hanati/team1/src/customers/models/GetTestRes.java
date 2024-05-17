package com.hanati.team1.src.customers.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetTestRes {
    private final int userId;
    private final String email;
    private final String nickname;
    private final String phoneNumber;
}
