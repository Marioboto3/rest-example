package edu.upc.dsa.services;

import edu.upc.dsa.TracksManager;
import edu.upc.dsa.TracksManagerImpl;
import edu.upc.dsa.models.Album;
import edu.upc.dsa.models.AlbumTO;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/albums", description = "Endpoint to AlbumService Service")
@Path("/albums")
public class AlbumService {
    private TracksManager tm;
    public AlbumService() {
        this.tm = TracksManagerImpl.getInstance();
        if (tm.size() == 0) {
            this.tm.addTrack("La Barbacoa", "Georgie", "Al 1");
            this.tm.addTrack("Despacito", "Luis", "Al 2");
            this.tm.addTrack("Enter Sandman", "Metallica", "Al3");

            this.tm.addAlbum("Al 1", 2000);
            this.tm.addAlbum("Al 2", 1900);
            this.tm.addAlbum("Al 3", 1800);

            this.tm.addAutor("Luis", "Fonsi", 123456789);
            this.tm.addAutor("Georgie", "Dann", 132547698);
            this.tm.addAutor("Metallica", "Metals", 987654321);
        }
    }
    @GET
    @ApiOperation(value = "get Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = AlbumTO.class, responseContainer="List"),
    })
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlbum(@PathParam("title") String title) {

        Album album = this.tm.getAlbum(title);
        AlbumTO albumTO =this.tm.passAlbumToAlbumTO(album);

        GenericEntity<AlbumTO> entity = new GenericEntity<AlbumTO>(albumTO) {};
        return Response.status(201).entity(entity).build()  ;

    }



}
