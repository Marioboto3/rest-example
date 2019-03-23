package edu.upc.dsa;

import edu.upc.dsa.models.Album;
import edu.upc.dsa.models.AlbumTO;
import edu.upc.dsa.models.Autor;
import edu.upc.dsa.models.Track;

import java.util.List;

public interface TracksManager {

    public Track addTrack(Track t);
    //TRACK
    public Track addTrack(String title, String singer, String tituloAlbum);
    public Track getTrack(String id);
    public void deleteTrack(String id);
    public Track updateTrack(Track t);
    public List<Track> findAll();
    public List<Track> getTracksAutor(String nombre);
    //ALBUM
    public Album addAlbum (String titulo, int año);
    public Album getAlbum(String nombre);
    public AlbumTO passAlbumToAlbumTO(Album album);
    //AUTOR
    public Autor addAutor(String nombre, String apellido, int dni);
   //FIND
    public Track findByIdTrack(String id,String tituloAlbum);
    public Album findByStringAlbum (String tituloAlbum);
    public Autor findByNameAutor(String nombre);
    //
    public int size();

}
