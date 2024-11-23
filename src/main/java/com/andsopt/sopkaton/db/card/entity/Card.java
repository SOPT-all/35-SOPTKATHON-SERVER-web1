package com.andsopt.sopkaton.db.card.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    // 임수 이런거
    @Column(name = "name", columnDefinition = "varchar(10)", nullable = false)
    private String name;

    @Column(name = "main_image_url", columnDefinition = "text", nullable = false)
    private String mainImageUrl;

    @Column(name = "sub_image_url", columnDefinition = "text", nullable = false)
    private String subImageUrl;

    //갑 을 병 정 이런거

    @Column(name = "ten_years", columnDefinition = "varchar(10)", nullable = false)
    private String tenYears;

}
