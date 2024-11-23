package com.andsopt.sopkaton.db.fortune.repository;

import com.andsopt.sopkaton.db.fortune.entity.Fortune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FortuneRepository extends JpaRepository<Fortune, Long> {
}
