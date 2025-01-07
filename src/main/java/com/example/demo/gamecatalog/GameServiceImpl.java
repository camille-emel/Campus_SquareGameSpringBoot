package com.example.demo.gamecatalog;

//import com.example.demo.gamecatalog.dao.MySQLUserDAO;
import com.example.demo.gamecatalog.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {


    @Autowired
    GameCatalog gameCatalog;
    @Autowired
    List<GamePlugin> gamePlugins;
    private final Map<UUID, Game> games = new HashMap<>();

    @Override
    public Game createGame(GameCreationParams params) {
        GamePlugin plugin = gamePlugins.stream()
                .filter(gamePlugin -> gamePlugin.getGameIdentifier().equals(params.gameIdentifier))
                .findFirst()
                .orElse(null);
        if (plugin == null) {
            return null;
        }
        OptionalInt playerCount = params.getPlayerCount()>0 ? OptionalInt.of(params.getPlayerCount()) : OptionalInt.empty();
        OptionalInt boardSize = params.getBoardSize()>0 ? OptionalInt.of(params.getBoardSize()) : OptionalInt.empty();
        Game game = plugin.createGame(playerCount, boardSize);
//        GameFactory factory = gameCatalog.getFactory(params.getGameIdentifier());
//        Game game = factory.createGame(params.getPlayerCount(), params.getBoardSize());
        games.put(game.getId(), game);
        return game;
    }

    @Override
    public Game getGame(UUID gameId) {
        return games.get(gameId);
    }

    @Override
    public List<Game> getGames() {
        return new ArrayList<>(games.values());
    }

    @Override
    public Game deleteGame(UUID gameId) {
        return games.remove(gameId);
    }
}
