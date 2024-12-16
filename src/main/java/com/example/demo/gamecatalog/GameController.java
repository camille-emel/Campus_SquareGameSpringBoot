package com.example.demo.gamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//decoration de la class pour indiquer qu'elle expose des endpoints REST
@RestController
@RequestMapping("/games")
public class GameController {

    @PostMapping
    public String createGame(@RequestBody GameCreationParams params) {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable String gameId) {
        return null;
    }

}
