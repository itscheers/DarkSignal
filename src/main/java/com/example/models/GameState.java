package com.example.models;

public class GameState {
    private String playerName;
    private int gameCounter;
    private String currentQuestion;
    private boolean gameOver;
    private String resultMessage;


    public GameState() {
        this.currentQuestion = "You received a mysterious message. Read it?";
        this.gameOver = false;
    }


    public GameState(String playerName, int gameCounter) {
        this.playerName = playerName;
        this.gameCounter = gameCounter;
        this.currentQuestion = "You received a mysterious message. Read it?";
        this.gameOver = false;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGameCounter() {
        return gameCounter;
    }

    public void setGameCounter(int gameCounter) {
        this.gameCounter = gameCounter;
    }

    public String getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(String currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
