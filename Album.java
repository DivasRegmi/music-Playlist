package com.Boss;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;

    private songList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new songList();
    }
    public boolean addSongs(String tittle, String duration){
        return songs.add(new Song(tittle,duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        Song checkSong = this.songs.findSong(trackNumber);
        if(checkSong != null){
            playList.add(checkSong);
            return true;
        }
        System.out.println("(Track number " + trackNumber+ ") does not exist in a album.");
        return false;
    }

    public boolean addToPlayList(String tittle, LinkedList<Song> playList){
        Song checkSong = this.songs.findSongs(tittle);
        if (checkSong != null){
            playList.add(checkSong);
            return  true;
        }

        System.out.println("Song(" + tittle + ") does not exist in album");
        return false;
    }

    private class songList{
        private ArrayList<Song> songs;

        public songList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song){
            if(songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSongs(String tittle){
            for(Song checkSong : this.songs){
                if(checkSong.getTittle().equals(tittle)){
                    return checkSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if((index >= 0) && (index < songs.size())){
                return songs.get(index);
            }
            return null;
        }


    }

}
