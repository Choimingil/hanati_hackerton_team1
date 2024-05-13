package com.hanati.team1.src.domain1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Table(name="{entity_name}")
@ToString
@Getter
@Setter
public class TestEntity {
    // PK 설정 부분, PK 컬럼 명에 따라 @Column 의 name 부분을 수정해주시면 됩니다.
    // 주의 : DB의 컬럼명으로 스프링 내에서 쿼리 작성하시면 안되고 새롭게 정의한 변수명으로 정의해야 합니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, insertable = false, updatable = false)
    private long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    // TimeStamp 타입 정의 예시
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createAt", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createAt;
}
