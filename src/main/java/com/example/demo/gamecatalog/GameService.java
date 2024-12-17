package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    Game createGame(GameCreationParams params);
    Game getGame(String gameId);
}
