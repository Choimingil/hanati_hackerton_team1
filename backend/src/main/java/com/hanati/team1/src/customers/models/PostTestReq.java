package com.hanati.team1.src.customers.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class PostTestReq {
    private String email;
    private String password;
}
