package edu.upc.dsa;

import edu.upc.dsa.models.Album;
import edu.upc.dsa.models.Autor;
import edu.upc.dsa.models.Track;

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

    public int size() {
        int ret = this.tracks.size();
        logger.info("size " + ret);

        return ret;
    }

    @Override
    public Track addTrack(String title, String singer, String tituloAlbum) {
        Track t= new Track(title,singer,tituloAlbum);
        logger.info("new Track " + t);
        Album a = findByStringAlbum(tituloAlbum);
        if(a != null) {
            a.añadirTrack(t);
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
    public Autor addAutor(String nombre, String apellido, int dni) {
        /*Autor a = findByName(nombre);*/
        /*if(a==null)
        {*/
            Autor a = new Autor(nombre, apellido, dni);
            logger.info("new Autor" + a);
            this.autores.put(a.getNombre(),a);
            logger.info("new Autor added");
            return a;/*
        }
        else{return null;}*/

    }

    public Track addTrack(Track t) {
        logger.info("new Track " + t);

        this.tracks.add (t);
        logger.info("new Track added");
        return t;
    }

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

    public List<Track> findAll() {
        return this.tracks;
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
    public Album getAlbum(Album nombre) {
        return null;
    }

    @Override
    public List<Track> dameTracksAutor(int dni) {
        return null;
    }

    @Override
    public Track findById(String id) {
        Track e = this.tracks.get(Integer.parseInt(id));
        if(e!=null) {
            return e;
        }
     else return null;
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
    public Autor findByName(String nombre) {
        Autor a = this.autores.get(nombre);
        if(a!=null)
        {
            return a;
        }
        else return null;
    }
}