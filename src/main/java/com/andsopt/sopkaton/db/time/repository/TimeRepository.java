package com.andsopt.sopkaton.db.time.repository;

import com.andsopt.sopkaton.db.time.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
