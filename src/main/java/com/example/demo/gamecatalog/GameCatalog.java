package com.example.demo.gamecatalog;

import com.example.demo.gamecatalog.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Collection;
//permettant de récupérer la liste des identiants des jeux d
public interface GameCatalog {
    Collection<GamePlugin> getPlugins();
    GameFactory getFactory(String Id);
}
