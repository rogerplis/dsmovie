package com.devsuperior.dsmovie.repository;

import com.devsuperior.dsmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepositorie extends JpaRepository<Movie, Long> {
}
