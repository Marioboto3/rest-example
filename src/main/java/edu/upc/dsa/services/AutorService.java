package edu.upc.dsa.services;

import edu.upc.dsa.TracksManager;
import edu.upc.dsa.TracksManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/autores", description = "Endpoint to AlbumService Service")
@Path("/autores")
public class AutorService {
    private TracksManager tm;
    public AutorService() {
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
    @ApiOperation(value = "get Autor", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = AlbumTO.class, responseContainer="List"),
    })
    @Path("/{autor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutor(@PathParam("autor") String nameAutor) {

        Autor autor = this.tm.getAutor(nameAutor);
        AutorTO autorTO = this.tm.passAutorToAutorTO(autor);

        GenericEntity<AutorTO> entity = new GenericEntity<AutorTO>(autorTO) {};
        return Response.status(201).entity(entity).build();

    }
    @GET
    @ApiOperation(value = "get all Autor's tracks", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class, responseContainer="List"),
    })
    @Path("/{autor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracksAlbum(@PathParam("autor") String nameAutor) {

        List<TrackTO> tracksTO = this.tm.getTracksAutor(nameAutor);
        GenericEntity<List<TrackTO>> entity = new GenericEntity<List<TrackTO>>(tracksTO) {};
        return Response.status(201).entity(entity).build();

    }
}
