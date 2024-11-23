package com.andsopt.sopkaton.db.fortune.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "fortune")
public class Fortune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String name;

    @Column(columnDefinition = "text", nullable = false)
    private String todayDate;

    @Column(columnDefinition = "text", nullable = false)
    private String lastDate;

    @Column(columnDefinition = "text", nullable = false)
    private String cardName;

    @Column(columnDefinition = "text", nullable = false)
    private String mainCardImageUrl;

    @Column(columnDefinition = "text", nullable = false)
    private String subCardImageUrl;

    @Column(columnDefinition = "text", nullable = false)
    private String cardContent;

    @Column(columnDefinition = "text", nullable = false)
    private String moneyContent;

    @Column(columnDefinition = "text", nullable = false)
    private String cautionContent;

    @Column(columnDefinition = "text", nullable = false)
    private String notableContent;

    @Column(columnDefinition = "text", nullable = false)
    private String totalContent;

    @Builder
    public Fortune(String name, String todayDate, String lastDate, String cardName, String mainCardImageUrl, String subCardImageUrl, String cardContent, String moneyContent, String cautionContent, String notableContent, String totalContent) {
        this.name = name;
        this.todayDate = todayDate;
        this.lastDate = lastDate;
        this.cardName = cardName;
        this.mainCardImageUrl = mainCardImageUrl;
        this.subCardImageUrl = subCardImageUrl;
        this.cardContent = cardContent;
        this.moneyContent = moneyContent;
        this.cautionContent = cautionContent;
        this.notableContent = notableContent;
        this.totalContent = totalContent;
    }
}
