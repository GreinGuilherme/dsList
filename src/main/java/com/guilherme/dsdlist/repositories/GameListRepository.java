package com.guilherme.dsdlist.repositories;

import com.guilherme.dsdlist.entities.Game;
import com.guilherme.dsdlist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
