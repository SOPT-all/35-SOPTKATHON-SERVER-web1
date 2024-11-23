package com.andsopt.sopkaton.db.calender.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "calender")
public class Calender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @Column(name = "birthYear", columnDefinition = "varchar(10)", nullable = false)
    private String birthYear;

    @Column(name = "birthMonth", columnDefinition = "varchar(10)", nullable = false)
    private String birthMonth;

    @Column(name = "birthDay", columnDefinition = "varchar(10)", nullable = false)
    private String birthDay;

    @Column(name = "lunar_year", columnDefinition = "varchar(10)", nullable = false)
    private String lunarYear;

    @Column(name = "lunar_month", columnDefinition = "varchar(10)", nullable = false)
    private String lunarMonth;

    @Column(name = "lunar_day", columnDefinition = "varchar(10)", nullable = false)
    private String lunarDay;

    @Column(name = "ganji_year_han", columnDefinition = "varchar(10)", nullable = false)
    private String ganjiYearHan;

    @Column(name = "ganji_year_ko", columnDefinition = "varchar(10)", nullable = false)
    private String ganjiYearKo;

    @Column(name = "ganji_month_han", columnDefinition = "varchar(10)", nullable = false)
    private String ganjiMonthHan;

    @Column(name = "ganji_month_ko", columnDefinition = "varchar(10)", nullable = false)
    private String ganjiMonthKo;

    @Column(name = "ganji_day_han", columnDefinition = "varchar(10)", nullable = false)
    private String ganjiDayHan;

    @Column(name = "ganji_day_ko", columnDefinition = "varchar(10)", nullable = false)
    private String ganjiDayKo;


}
