package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
    public Game getGame(@PathVariable int gameId) {
        if (gameService.getGame(gameId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return gameService.getGame(gameId);
    }
    @GetMapping("/all")
    public List<Game> getAllGames() {
        return gameService.getGames();
    }
    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable int gameId) {
        if (gameService.deleteGame(gameId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
