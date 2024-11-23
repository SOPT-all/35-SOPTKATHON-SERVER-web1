package com.andsopt.sopkaton.db.time.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @Column(name = "period", columnDefinition = "varchar(25)", nullable = false)
    private String period;

    @Column(name = "ganji_time", columnDefinition = "varchar(25)", nullable = false)
    private String ganjiTime;
}
