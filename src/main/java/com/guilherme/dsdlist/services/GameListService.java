package com.guilherme.dsdlist.services;

import com.guilherme.dsdlist.dto.GameDTO;
import com.guilherme.dsdlist.dto.GameListDTO;
import com.guilherme.dsdlist.dto.GameMinDTO;
import com.guilherme.dsdlist.entities.Game;
import com.guilherme.dsdlist.projections.GameMinProjection;
import com.guilherme.dsdlist.repositories.GameListRepository;
import com.guilherme.dsdlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository  gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        var result = gameListRepository.findAll();
        //List<GameMinDTO> dto = result.stream().map(GameMinDTO::new).toList();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i < max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

//    @Transactional(readOnly = true)
//    public GameDTO findById(Long id) {
//        Game result = gameListRepository.findById(id).get();
//        return new GameDTO(result);
//    }
}
