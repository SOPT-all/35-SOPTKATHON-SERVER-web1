package com.andsopt.sopkaton.db.card.repository;

import com.andsopt.sopkaton.db.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card findByTenYears(final String tenYears);
}
