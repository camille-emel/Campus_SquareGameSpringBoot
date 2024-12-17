package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
//decoration de la class pour indiquer qu'elle expose des endpoints REST
@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    //Pour une création de ressource, on utilise la méthode HTTP POST
    //Code engine -> @NotNull Game createGame(int playerCount, int boardSize);
    @PostMapping
    public Game createGame(@RequestBody GameCreationParams params) {
        return gameService.createGame(params);
    }

    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable String gameId) {
        return gameService.getGame(gameId);
    }
}
