package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GameService {
    Game createGame(GameCreationParams params);
    Game getGame(UUID gameId);
    List<Game> getGames();
    Game deleteGame(UUID gameId);
}
