package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Album {

    int año;
    String titulo;
    List<Track> list = new ArrayList<>();

    public Album(int año, String titulo) {
        this.año = año;
        this.titulo = titulo;
    }
    public Album() {
    }
    public int getSize(){
        return this.list.size();
    }
    public int getAño() {
        return año;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Track> getList() {
        return list;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void añadirTrack(Track t)
    {
        this.list.add(t);
    }
}
