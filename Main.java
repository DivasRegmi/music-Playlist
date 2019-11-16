package com.Boss;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static LinkedList<Album> albums = new LinkedList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Mid-Night Memories", "One Direction");
        album.addSongs("Night changes", "04:55");
        album.addSongs("No control", "03:55");
        album.addSongs("Still my girl", "04:25");
        album.addSongs("Fire on road", "03:55");
        album.addSongs("Shadow", "04:06");
        album.addSongs("Little Things", "05:55");
        albums.add(album);


        album = new Album("For those about to rock", "AC/DC");
        album.addSongs("For those about to rock", "5.45");
        album.addSongs("I put the finger on you", "3.5");
        album.addSongs("Lets go", "4.25");
        album.addSongs("C.O.D.", "7.01");
        album.addSongs("Breaking the rules", "4.55");
        album.addSongs("Night of the long knives", "6.55");
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList(1, playList);
        albums.get(0).addToPlayList(2, playList);
        albums.get(0).addToPlayList(3, playList);
        albums.get(0).addToPlayList(11, playList); //Does not exist.

        albums.get(1).addToPlayList("I put the finger on you", playList);
        albums.get(1).addToPlayList("For those about to rock", playList);
        albums.get(1).addToPlayList("For those about to rock", playList); //DOuble.
        albums.get(1).addToPlayList("Lets go", playList);
        albums.get(1).addToPlayList("Hero", playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playlist) {
        ListIterator<Song> listIterator = playlist.listIterator();

        boolean quit = false;
        boolean hasForward = true;


        if (playlist.size() == 0) {
            System.out.println("No Song to play");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        printMenu();

        while (!quit) {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if(!hasForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        hasForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("This is the last song on you. ");
                        hasForward = false;
                    }
                    break;
                case 2:
                    if(hasForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        hasForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("You are on top of list.");
                        hasForward = true;
                    }
                    break;
                case 3:
                    if(hasForward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                            hasForward = false;
                        }else {
                            System.out.println("You are on top of list.");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            hasForward = true;
                        }else {
                            System.out.println("You are last of list.");
                        }
                    }
                    break;

                case 4:
                    printList(playlist);
                    break;

                case 5:
                    printMenu();
                    break;
                case 6:
                   if(playlist.size() >0){
                       listIterator.remove();
                       if(listIterator.hasNext()){
                           System.out.println("Now playing " + listIterator.next());
                       }else if(listIterator.hasPrevious()){
                           System.out.println("Now playing " + listIterator.previous());
                       }else {
                           System.out.println("No song in play list.");
                       }
                   }

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }

    private static void printList(LinkedList<Song> playList) {
        ListIterator<Song> listIterator = playList.listIterator();
        int count = 1;
        System.out.println("=============================");
        while (listIterator.hasNext()) {
            System.out.println(count +"." + listIterator.next().toString());
            count++;
        }
        System.out.println("============================");

    }


}