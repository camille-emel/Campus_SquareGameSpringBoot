package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameCatalog gameCatalog;


    @Override
    public Game createGame(GameCreationParams params) {
         GameFactory factory = gameCatalog.getFactory(params.getType());
         return factory.createGame(params.getPlayCount(), params.getBoardSize());
    }

    @Override
    public Game getGame(String gameId) {
        return null;
    }
}
