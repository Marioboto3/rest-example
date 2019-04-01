package edu.upc.dsa.services;

import edu.upc.dsa.TracksManager;
import edu.upc.dsa.TracksManagerImpl;
import edu.upc.dsa.models.Album;
import edu.upc.dsa.models.AlbumTO;
import edu.upc.dsa.models.Track;
import edu.upc.dsa.models.TrackTO;
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
            tm.addAlbum("123",2000);
            tm.addAlbum("Vente",1900);
            tm.addAlbum("Baby",1800);

            tm.addAutor("Natos","Tada",12345678);
            tm.addAutor("Rafael","Pele",87654321);

            tm.addTrack("Balada","Rafael","Vente");
            tm.addTrack("Problemas","Natos","123");
            tm.addTrack("Host","Rafael","Vente");
            tm.addTrack("Fairplay","Rafael","Baby");
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

        return Response.status(201).entity(albumTO).build()  ;

    }
    @GET
    @ApiOperation(value = "get all Track of Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = TrackTO.class, responseContainer="List"),
    })
    @Path("/{title}/tracks")//Tiene que ser /tracks sino es exactamente igual que el getAlbum /title y no los distingue
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracksAlbum(@PathParam("title") String title) {

        List<TrackTO> tracksTO = this.tm.getTracksAlbum(title);
        GenericEntity<List<TrackTO>> entity = new GenericEntity<List<TrackTO>>(tracksTO) {};
        return Response.status(201).entity(entity).build()  ;
    }
}
