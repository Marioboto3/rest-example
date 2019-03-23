package edu.upc.dsa;

import edu.upc.dsa.models.Album;
import edu.upc.dsa.models.Autor;
import edu.upc.dsa.models.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TracksManagerTest {
    TracksManager tmi;
    Album a;
    Autor s;
    @Before
    public void Initializate(){
        a = new Album(2000, "123");
        tmi = TracksManagerImpl.getInstance();
    }
    /*@Test
    public void findById(){
        a=tmi.addAlbum("123",2000);
        Track t = new Track("Balada","Rafael","123");
    }*/
    @Test
    public void findByNameAutorTest(){
        s=tmi.addAutor("Pepe","Palotes",1234);
        Autor autor=tmi.findByName("Pepe");
        assertEquals("Pepe",autor.getNombre());
    }
    @Test
    public void findByStringAlbum(){
        a=tmi.addAlbum("123",2000);
        String titulo="123";
        Album b = tmi.findByStringAlbum(titulo);
        assertEquals(a.getTitulo(),b.getTitulo());
    }
    @Test
    public void añadirAlbumTest(){
        a=tmi.addAlbum("123",2000);
        assertEquals("123",a.getTitulo());
    }
    @Test
    public void añadirTrackTest(){
        a=tmi.addAlbum("123",2000);
        tmi.addTrack("Problemas", "Natos", "123");
        assertEquals(1, a.getSize());
    }
    @Test
    public void añadirAutorTest(){
        s=tmi.addAutor("Pepe","Palotes",1234);
        assertEquals("Pepe",s.getNombre());
    }
}
