package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {
    TicTacToeGameFactory gameFactory = new TicTacToeGameFactory();;


    @Override
    public Collection<String> getGameIdentifiers() {
        return List.of(gameFactory.getGameFactoryId());
    }
}
