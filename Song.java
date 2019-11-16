package com.Boss;

public class Song {
    private String tittle;
    private String duration;

    public Song(String name, String duration) {
        this.tittle = name;
        this.duration = duration;
    }

    public String getTittle() {
        return tittle;
    }

    @Override
    public String toString() {
        return this.tittle + ":--> " + this.duration;
    }
}
