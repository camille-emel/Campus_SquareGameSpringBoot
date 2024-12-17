package com.example.demo.gamecatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GameCatalogController {
    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/games")
    public Collection<String> getGames() {
       return gameCatalog.getGamesIdentifiers();
    }
}
