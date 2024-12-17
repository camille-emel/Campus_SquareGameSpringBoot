package com.example.demo.gamecatalog;

public class GameCreationParams {
    String typeOfGame;
    int playerCount;
    int boardSize;

    public String getType() {
        return typeOfGame;
    }

    public void setType(String type) {
        this.typeOfGame = type;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playCount) {
        this.playerCount = playCount;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }


}
