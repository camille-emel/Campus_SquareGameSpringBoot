package com.example.demo.gamecatalog;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class GameCreationParams {
    String gameIdentifier;
    int playerCount;
    int boardSize;

    public @NotBlank String getGameIdentifier() {
        return gameIdentifier;
    }

    public @Min(1) int getPlayerCount() {
        return playerCount;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
