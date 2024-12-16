package com.example.demo.gamecatalog;

public class GameCreationParams {
    String typeOfGame;
    int playCount;
    int boardSize;

    public String getType() {
        return typeOfGame;
    }

    public void setType(String type) {
        this.typeOfGame = type;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

}
