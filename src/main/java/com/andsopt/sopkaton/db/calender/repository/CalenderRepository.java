package com.andsopt.sopkaton.db.calender.repository;

import com.andsopt.sopkaton.db.calender.entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalenderRepository extends JpaRepository<Calender, Integer> {

    Calender findByBirthYearAndBirthMonthAndBirthDay(final String year, final String month, final String day);

    Calender findByLunarYearAndLunarMonthAndLunarDay(final String year, final String month, final String day);
}
