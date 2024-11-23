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

    @Column(name = "year", columnDefinition = "varchar(10)", nullable = false)
    private String year;

    @Column(name = "month", columnDefinition = "varchar(10)", nullable = false)
    private String month;

    @Column(name = "day", columnDefinition = "varchar(10)", nullable = false)
    private String day;

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

    @Column(name = "ganji_day_ho", columnDefinition = "varchar(10)", nullable = false)
    private String ganjiDayHo;


}
