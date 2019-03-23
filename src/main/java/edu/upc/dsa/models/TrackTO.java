package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class TrackTO {

    String id;
    String title;
    String autor;
    String tituloAlbum;


    public TrackTO() {
    }

    public TrackTO(String title, String autor, String tituloAlbum) {
        this.title = title;
        this.autor = autor;
        this.tituloAlbum=tituloAlbum;
        this.id = RandomUtils.getId();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public void setTituloAlbum(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return "Track [id="+id+", title=" + title + ", singer=" + autor +"]";
    }

}
