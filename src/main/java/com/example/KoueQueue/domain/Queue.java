package com.example.KoueQueue.domain;

public class Queue {
    private String username;
    private long id;
    private int timePlayed;

    public Queue(String username, Long id, int timePlayed){
        this.username = username;
        this.id = id;
        this.timePlayed = timePlayed;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }
}
