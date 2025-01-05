package com.example.demo.gamecatalog.dao;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Optional;
import java.util.stream.Stream;

public interface GameDAO {
    Stream<Game> findAll();
    Optional<Game> findById(String gameId);
    Game upsert(Game game);
    void delete(String gameId);
}
