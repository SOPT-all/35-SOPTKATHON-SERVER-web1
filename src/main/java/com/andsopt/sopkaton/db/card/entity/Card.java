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

    @Column(name = "name", columnDefinition = "varchar(10)", nullable = false)
    private String name;

    @Column(name = "image_url", columnDefinition = "text", nullable = false)
    private String imageUrl;

    @Column(name = "ten_years", columnDefinition = "varchar(10)", nullable = false)
    private String tenYears;

}
