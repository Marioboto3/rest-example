package edu.upc.dsa.models;

import java.util.List;

public class AlbumTO {
    int año;
    String title;
    List<String> tracks;

    public AlbumTO() {
        this.tracks = tracks;
    }

    public int getAño() {
        return año;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setAño(int año) {
        this.año = año;
    }
    public int getSize(){
        return this.tracks.size();
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
