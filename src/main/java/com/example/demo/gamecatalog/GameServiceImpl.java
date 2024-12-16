package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {


    @Override
    public String createGame(String typeOfGame,
                             int playCount,
                             int boardSize) {
        return;
    }

    @Override
    public Game getGame(String gameId) {
        return null;
    }
}
