package com.example.KoueQueue.domain;

public class ListOfGames {
    private String firstPlayer;
    private String secondPlayer;
    private String thirdPlayer;
    private String fourthPlayer;
    private String time;


    public ListOfGames() {
    }

    public ListOfGames(String firstPlayer, String secondPlayer, String thirdPlayer, String fourthPlayer, String time) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.thirdPlayer = thirdPlayer;
        this.fourthPlayer = fourthPlayer;
        this.time = time;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public String getThirdPlayer() {
        return thirdPlayer;
    }

    public void setThirdPlayer(String thirdPlayer) {
        this.thirdPlayer = thirdPlayer;
    }

    public String getFourthPlayer() {
        return fourthPlayer;
    }

    public void setFourthPlayer(String fourthPlayer) {
        this.fourthPlayer = fourthPlayer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}