package com.devsuperior.dsmovie.repository;

import com.devsuperior.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorie extends JpaRepository<User, Long> {
}
