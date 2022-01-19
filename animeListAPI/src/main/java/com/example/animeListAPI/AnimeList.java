package com.example.animeListAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnimeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int rating;
    private int progress;
    private boolean completed;

  public AnimeList() {

  }
    public AnimeList(int id, String title, int rating, int progress, boolean completed) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.progress = progress;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public int getProgress() {
        return progress;
    }

    public boolean getCompleted() {
        return completed;
    }
}
