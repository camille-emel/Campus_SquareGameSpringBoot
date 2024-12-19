package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public Game createGame(@RequestBody @Validated GameCreationParams params) {
        return gameService.createGame(params);
    }

    @GetMapping("/all")
    public List<Game> getAllGames() {
        return gameService.getGames();
    }

    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable UUID gameId) {
        if (gameService.getGame(gameId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }
        return gameService.getGame(gameId);
    }


    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable UUID gameId) {
        if (gameService.deleteGame(gameId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
