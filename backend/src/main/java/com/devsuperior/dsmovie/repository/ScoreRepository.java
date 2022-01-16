package com.devsuperior.dsmovie.repository;

import com.devsuperior.dsmovie.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
