package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameCatalog gameCatalog;
    List<Game> games = new ArrayList<>();


        @Override
    public Game createGame(GameCreationParams params) {
         GameFactory factory = gameCatalog.getFactory(params.getType());
         return factory.createGame(params.getPlayerCount(), params.getBoardSize());
    }


    @Override
    public Game getGame(int gameId) {
        return games.get(gameId);
    }

    @Override
    public List<Game> getGames() {
        return new ArrayList<>(games);
    }
    @Override
    public Game deleteGame(int gameId){
        if (gameId < 0 || gameId >= games.size()){
           return null;
        }
        return games.remove(gameId);
    }
}
