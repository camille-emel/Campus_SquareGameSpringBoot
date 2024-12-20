package com.example.demo.gamecatalog.plugin;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.OptionalInt;

@Component
public class ConnectFourPlugin implements GamePlugin {

    @Value("${game.connectfour.default-player-count}")
    private int defaultPlayerCount;

    @Value("${game.connectfour.default-board-size}")
    private int defaultBoardSize;

    @Autowired
    private MessageSource messageSource;

    private final ConnectFourGameFactory connectFour = new ConnectFourGameFactory();

    @Override
    public String getName(Locale locale) {
        return messageSource.getMessage("game.connectfour.name", null, locale);
    }

    @Override
    public String getGameIdentifier() {
        return "ConnectFour";
    }

    @Override
    public Game createGame(OptionalInt playerCount, OptionalInt boardSize) {
        int finalPlayerCount = playerCount.orElse(defaultPlayerCount);
        int finalBoardSize = boardSize.orElse(defaultBoardSize);
        return connectFour.createGame(finalPlayerCount, finalBoardSize);
    }
}
