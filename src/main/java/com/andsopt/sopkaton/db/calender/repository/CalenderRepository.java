package com.andsopt.sopkaton.db.calender.repository;

import com.andsopt.sopkaton.db.calender.entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalenderRepository extends JpaRepository<Calender, Integer> {
}
