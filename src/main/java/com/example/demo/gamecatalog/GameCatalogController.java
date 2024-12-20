package com.example.demo.gamecatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

@RestController
public class GameCatalogController {
    @Autowired
    private GameCatalog gameCatalog;


    @GetMapping("/games/catalog")
    //??wtf is this, I dont get it???
    public Collection<Map<String, String>> getGames(Locale locale) {
        return this.gameCatalog.getPlugins().stream()
                .map(plugin -> Map.of(
                        "id", plugin.getClass().getSimpleName().toLowerCase().replace("plugin", ""),
                        "name", plugin.getName(locale)
                ))
                .toList();
    }
}
