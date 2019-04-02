package edu.upc.dsa;

import edu.upc.dsa.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class TracksManagerImpl implements TracksManager {
    private static TracksManager instance;
    protected List<Track> tracks;
    protected HashMap<String,Album> albumes;
    protected HashMap<String, Autor> autores;
    final static Logger logger = Logger.getLogger(TracksManagerImpl.class);

    private TracksManagerImpl() {
        this.tracks = new LinkedList<>();
        this.albumes = new HashMap<>();
        this.autores= new HashMap<>();
    }

    public static TracksManager getInstance() {
        if (instance==null) instance = new TracksManagerImpl();
        return instance;
    }

    public int sizeTracks() {
        int ret = this.tracks.size();
        logger.info("size " + ret);

        return ret;
    }

    public int sizeAutors(){
        int ret= this.autores.size();
        logger.info("size" + ret);
        return ret;
    }

    public int sizeAlbums(){
        int ret = this.albumes.size();
        logger.info("size" + ret);
        return ret;
    }

    @Override
    public Track addTrack(String title, String singer, String tituloAlbum) {
        Track t= new Track(title,singer,tituloAlbum);
        logger.info("new Track " + t);
        Album a = findByStringAlbum(tituloAlbum);
        Autor b = findByNameAutor(singer);
        if(a != null) {
            a.añadirTrack(t);
            b.añadirTrack(t);
            this.tracks.add(t);//Tienes que añadirlo en la lista de tracks melon
            logger.info("new Track added");
            return t;
        }
        else return null;
      }

    @Override
    public Album addAlbum(String titulo, int año) {
        Album a = findByStringAlbum(titulo);
        if (a==null) {
            a = new Album(año, titulo);
            logger.info("new Album" + a);
            this.albumes.put(a.getTitulo(),a);
            logger.info("new Album added");
            return a;
        }
        else return null;
    }

    @Override
    public Autor addAutor(String nombre, String apellido, int dni, int añoNacimiento) {
        /*Autor a = findByName(nombre);*/
        /*if(a==null)
        {*/
            Autor a = new Autor(nombre, apellido, dni, añoNacimiento);
            logger.info("new Autor" + a);
            this.autores.put(a.getNombre(),a);
            logger.info("new Autor added");
            return a;/*
        }
        else{return null;}*/

    }

    @Override
    public Autor getAutor(String nombre) {
        Autor autor = this.findByNameAutor(nombre);
        return autor;
    }

    @Override
    public Album getAlbum(String titulo)
    {
        logger.info("getAlbum("+titulo+")");
        Album a= findByStringAlbum(titulo);
        if(a!=null) {
            return a;
        }
        else return null;
    }

    @Override
    public Track getTrack(String id) {
        logger.info("getTrack("+id+")");

        for (Track t: this.tracks) {
            if (t.getId().equals(id)) {
                logger.info("getTrack("+id+"): "+t);

                return t;
            }
        }
        logger.warn("not found " + id);
        return null;
    }

    @Override
    public void deleteAutor(String nombre) {
        Autor a = this.getAutor(nombre);

        if (a==null) {
            logger.warn("not found " + a);
        }
        else logger.info(a+" deleted ");

        this.autores.remove(nombre);

    }

    @Override
    public void deleteAlbum(String nombre) {
        Album album = this.getAlbum(nombre);
        if (album==null) {
            logger.warn("not found " + album);
        }
        else logger.info(album+" deleted ");

        this.albumes.remove(nombre);
    }

    @Override
    public void deleteTrack(String id) {

        Track t = this.getTrack(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.tracks.remove(t);
    }

    @Override
    public AutorTO passAutorToAutorTO(Autor autor) {
        AutorTO autorTO = new AutorTO();
        autorTO.setNombre(autor.getNombre());
        autorTO.setApellido(autor.getApellido());
        autorTO.setDni(autor.getDni());
        autorTO.setAñoNacimiento(autor.getAñoNacimiento());
        autorTO.setNumTracks(autor.getSize());
        return autorTO;
    }

    @Override
    public AlbumTO passAlbumToAlbumTO(Album album) {
        AlbumTO albumTO = new AlbumTO();
        albumTO.setAño(album.getAño());
        albumTO.setTitle(album.getTitulo());
        albumTO.setNumTracks(album.getSize());
        return albumTO;
    }

    @Override
    public TrackTO passTracktoTrackTO(Track t) {
        TrackTO trackTO = new TrackTO();
        trackTO.setTitle(t.getTitle());
        trackTO.setAutor(t.getAutor());
        trackTO.setId(t.getId());
        trackTO.setTituloAlbum(t.getTituloAlbum());
        return trackTO;
    }

    @Override
    public Track updateTrack(Track p) {
        Track t = this.getTrack(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setAutor(p.getAutor());
            t.setTitle(p.getTitle());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }

    @Override
    public List<TrackTO> getTracksAutor(String nombre) {
        Autor a = findByNameAutor(nombre);
        List<TrackTO> tracksTO = new ArrayList<>();
        if(a!=null)
        {
            List<Track> lista= a.getList();
            for(Track t : lista)
            {
                tracksTO.add(this.passTracktoTrackTO(t));
            }
        }
        return tracksTO;
    }

    @Override
    public List<TrackTO> getTracksAlbum(String tituloAlbum) {
        Album album = this.getAlbum(tituloAlbum);
        List<TrackTO> tracksTO = new ArrayList<>();
        TrackTO trackTO = new TrackTO();
        for(Track t: album.getList())
        {
            trackTO = this.passTracktoTrackTO(t);
            tracksTO.add(trackTO);
        }
        return tracksTO;
    }

    public List<Track> findAll() {
        return this.tracks;
    }

    @Override
    public Track findByIdTrack(String id, String nombreAlbum) {
        Album album =findByStringAlbum(nombreAlbum);
        List<Track> lista = album.getList();
        Track track=null;
        for(Track t: lista)
        {
            if (t.getId().equals(id)){
                track=t;
            }
        }
        return track;

    }

    @Override
    public Album findByStringAlbum(String id) {

        Album a = this.albumes.get(id);
        if(a!=null) {
            return a;
        }
        else return null;
    }

    @Override
    public Autor findByNameAutor(String nombre) {
        Autor a = this.autores.get(nombre);
        if(a!=null)
        {
            return a;
        }
        else return null;
    }

    public Track addTrack(Track t) {
        logger.info("new Track " + t);

        this.tracks.add (t);
        logger.info("new Track added");
        return t;
    }

}