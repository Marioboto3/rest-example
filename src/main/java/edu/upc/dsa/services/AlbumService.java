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
        if (tm.sizeTracks() == 0) {
            tm.addAlbum("123",2000);
            tm.addAlbum("Vente",1900);
            tm.addAlbum("Baby",1800);

            tm.addAutor("Natos","Tada",12345678, 1990);
            tm.addAutor("Rafael","Pele",87654321, 1930);

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
    @POST
    @ApiOperation(value = "create a new Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=AlbumTO.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newAlbum(AlbumTO album) {

        if ((album.getTitle())==null || album.getAño()==0){
            album.setNumTracks(0);
            return Response.status(500).entity(album).build();}
        this.tm.addAlbum(album.getTitle(),album.getAño());
        return Response.status(201).entity(album).build();
    }
    @PUT
    @ApiOperation(value = "update a Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Album not found")
    })
    @Path("/")
    public Response updateAlbum(AlbumTO albumTO) {

        AlbumTO a = this.tm.updateAlbumTO(albumTO);

        if (a == null) {
            return Response.status(404).build();
        }
        return Response.status(201).build();
    }
    @DELETE
    @ApiOperation(value = "delete a Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{nombre}")
    public Response deleteAlbum(@PathParam("nombre") String nombre) {
        Album a = this.tm.getAlbum(nombre);
        if (a == null) return Response.status(404).build();
        else this.tm.deleteAlbum(nombre);
        return Response.status(201).build();
    }

}
