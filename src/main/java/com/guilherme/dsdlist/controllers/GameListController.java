package com.guilherme.dsdlist.controllers;

import com.guilherme.dsdlist.dto.GameDTO;
import com.guilherme.dsdlist.dto.GameListDTO;
import com.guilherme.dsdlist.dto.GameMinDTO;
import com.guilherme.dsdlist.dto.ReplacementDTO;
import com.guilherme.dsdlist.services.GameListService;
import com.guilherme.dsdlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        var result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findAll(@PathVariable Long listId){
        var result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
