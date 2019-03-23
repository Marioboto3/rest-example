package edu.upc.dsa;

import edu.upc.dsa.models.Album;
import edu.upc.dsa.models.Autor;
import edu.upc.dsa.models.Track;

import java.util.List;

public interface TracksManager {


    public Track addTrack(String title, String singer, String tituloAlbum);
    public Track addTrack(Track t);
    public Track getTrack(String id);
    public List<Track> findAll();
    public void deleteTrack(String id);
    public Track updateTrack(Track t);
    public Autor addAutor(String nombre, String apellido, int dni);
    public Album addAlbum (String titulo, int año);
    public Album getAlbum(Album nombre);
    public List<Track> dameTracksAutor(int dni);
    public Track findById(String id);
    public Album findByStringAlbum (String tituloAlbum);
    public Autor findByName(String nombre);
    public int size();

}
