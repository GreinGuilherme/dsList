package com.guilherme.dsdlist.controllers;

import com.guilherme.dsdlist.dto.GameDTO;
import com.guilherme.dsdlist.dto.GameListDTO;
import com.guilherme.dsdlist.dto.GameMinDTO;
import com.guilherme.dsdlist.services.GameListService;
import com.guilherme.dsdlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        var result = gameListService.findAll();
        return result;
    }
}
