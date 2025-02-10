package com.guilherme.dsdlist.repositories;

import com.guilherme.dsdlist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
