package edu.upc.dsa.models;

import java.util.List;

public class AlbumTO {
    int año;
    int numTracks;
    String title;

    public AlbumTO() {
    }

    public int getNumTracks() {
        return numTracks;
    }
    public AlbumTO(String title, int año){this.title=title; this.año=año;}

    public void setNumTracks(int numTracks) {
        this.numTracks = numTracks;
    }

    public int getAño() {
        return año;
    }

    public String getTitle() {
        return title;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
