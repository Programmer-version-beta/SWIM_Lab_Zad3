package com.example.fabian.swim_lab_zad3;

import java.util.ArrayList;

class Movie {
    private String title, genre;
    private int imageUrl;
    private ArrayList <Actor> actors;
    private int [] images;


    Movie(String title, String genre, int imageUrl, ArrayList <Actor> actors, int [] images){
        this.title = title;
        this.genre = genre;
        this.imageUrl = imageUrl;
        this.actors = actors;
        this.images = images;
    }

    String getTitle(){
        return title;
    }

    String getGenre(){
        return genre;
    }

    ArrayList <Actor> getActors(){ return actors; }

    int getImageUrl(){ return imageUrl; }

    int getImages(int index){ return images[index]; }
}
