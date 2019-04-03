package edu.upc.dsa;

import edu.upc.dsa.models.*;

import java.util.List;

public interface TracksManager {

    public Track addTrack(Track t);
    //TRACK
    public Track addTrack(String title, String singer, String tituloAlbum);
    public Track getTrack(String id);
    public void deleteTrack(String id);
    public Track updateTrack(Track t);
    public List<Track> findAll();
    public List<TrackTO> getTracksAutor(String nombre);
    public List<TrackTO> getTracksAlbum (String tituloAlbum);
    public TrackTO passTracktoTrackTO(Track t);
    //ALBUM
    public Album addAlbum (String titulo, int año);
    public Album getAlbum(String nombre);
    public void deleteAlbum (String nombre);
    public AlbumTO updateAlbumTO (AlbumTO a);
    public AlbumTO passAlbumToAlbumTO(Album album);
    //AUTOR
    public Autor addAutor(String nombre, String apellido, int dni, int añoNacimiento);
    public Autor getAutor (String nombre);
    public void deleteAutor (String nombre);
    public AutorTO updateAutorTO (AutorTO aut);
    public AutorTO passAutorToAutorTO(Autor autor);
   //FIND
    public Track findByIdTrack(String id,String tituloAlbum);
    public Album findByStringAlbum (String tituloAlbum);
    public Autor findByNameAutor(String nombre);
    //
    public int sizeTracks();
    public int sizeAlbums();
    public int sizeAutors();

}
