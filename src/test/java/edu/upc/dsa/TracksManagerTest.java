package edu.upc.dsa;

import edu.upc.dsa.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TracksManagerTest {
    TracksManager tmi;
    @Before
    public void Initializate(){

        tmi = TracksManagerImpl.getInstance();

        Album a=tmi.addAlbum("123",2000);
        Album b=tmi.addAlbum("Vente",1900);
        Album c=tmi.addAlbum("Baby",1800);


        Autor s= tmi.addAutor("Natos","Tada",12345678);
        Autor t= tmi.addAutor("Rafael","Pele",87654321);

        Track m = tmi.addTrack("Balada","Rafael","Vente");
        Track n = tmi.addTrack("Problemas","Natos","123");
        tmi.addTrack("Pepito","Natos","123");
        Track o = tmi.addTrack("Host","Rafael","Vente");
        Track p = tmi.addTrack("Fairplay","Rafael","Baby");
    }

    @Test
    public void findByIdTest(){

        Album c = tmi.findByStringAlbum("123");
        Track t = tmi.addTrack("Miprima","Natos","123");
        String id =t.getId();
        c.añadirTrack(t);
        Track track = tmi.findByIdTrack(id,"123");
        assertEquals("Miprima", track.getTitle());
    }
    @Test
    public void findByNameAutorTest(){
        Autor autor=tmi.findByNameAutor("Rafael");
        assertEquals("Rafael",autor.getNombre());
    }
    @Test
    public void findByStringAlbum(){
        Album b = tmi.findByStringAlbum("123");
        assertEquals("123",b.getTitulo());
    }
    @Test
    public void añadirAlbumTest(){
       Album a=tmi.findByStringAlbum("123");
        assertEquals("123",a.getTitulo());
    }
    @Test
    public void añadirTrackTest(){
        Album a=tmi.findByStringAlbum("123");
        assertEquals(1, a.getSize());
        assertEquals(4,this.tmi.findAll().size());
    }
    @Test
    public void añadirAutorTest(){
        Autor s = tmi.findByNameAutor("Rafael");
        assertEquals("Rafael",s.getNombre());
    }
    @Test
    public void passAlbumToAlbumTO(){
        Album a=tmi.findByStringAlbum("123");
        AlbumTO aTO = tmi.passAlbumToAlbumTO(a);
        assertEquals("123",aTO.getTitle());
    }
    @Test
    public void passAutorToAutorTO(){
        Autor a=tmi.findByNameAutor("Rafael");
        AutorTO aTO= tmi.passAutorToAutorTO(a);
        assertEquals(3,aTO.getsize());
        assertEquals("Rafael",aTO.getNombre());
    }
    @Test
    public void passTrackToTrackTO(){
        Album c = tmi.findByStringAlbum("123");
        Track t = tmi.addTrack("Mivecina","Natos","123");
        String id =t.getId();
        c.añadirTrack(t);
        Track track = tmi.findByIdTrack(id,"123");
        assertEquals("Mivecina", track.getTitle());
        TrackTO trackTO = tmi.passTracktoTrackTO(track);
        assertEquals(track.getTitle(),trackTO.getTitle());

    }
    @Test
    public void getTracksAlbumTest(){
        Album a = tmi.findByStringAlbum("Vente");
        List<TrackTO> lista = tmi.getTracksAlbum(a.getTitulo());
        assertEquals(2,lista.size());
    }
    @Test
    public void getAlbumTest(){
        Album a = tmi.getAlbum("123");
        assertEquals(2000,a.getAño());
    }
    @Test
    public void getTracksAutorTest(){
        List<TrackTO> lista = tmi.getTracksAutor("Natos");
        assertEquals(2,lista.size());
    }
    @Test
    public void getAutorTest(){
        Autor autor = tmi.getAutor("Rafael");
        assertEquals("Rafael",autor.getNombre());
    }
    @Test
    public void getTracksTest(){//He puesto un test para ver si creaba bien la lista
        List<Track> trackList;
        trackList = this.tmi.findAll();
        assertEquals(5,trackList.size());
    }
}
