package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {
    TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
    TaquinGameFactory taquinFactory = new TaquinGameFactory();
    ConnectFourGameFactory connectFactory = new ConnectFourGameFactory();


    @Override
    public Collection<String> getGamesIdentifiers() {
        return List.of(ticTacToeGameFactory.getGameFactoryId(),
                taquinFactory.getGameFactoryId(),
                connectFactory.getGameFactoryId());


    }

    @Override
    public GameFactory getFactory(String gameIdentifier) {
        return switch (gameIdentifier) {
            case "TicTacToe" -> ticTacToeGameFactory;
            case "Taquin" -> taquinFactory;
            case "ConnectFour" -> connectFactory;
            default -> null;
        };
    }
}
