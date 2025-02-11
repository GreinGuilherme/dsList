package com.guilherme.dsdlist.dto;

import com.guilherme.dsdlist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameList game) {
        this.id = game.getId();
        this.name = game.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
