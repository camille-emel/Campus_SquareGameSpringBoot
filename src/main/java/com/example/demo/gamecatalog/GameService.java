package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;

public interface GameService {
    String createGame(GameCreationParams params);
    Game getGame(String gameId);
}
