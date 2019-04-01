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
    @ApiOperation(value = "get Autor", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = AutorTO.class, responseContainer="List"),
    })
    @Path("/{autor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutor(@PathParam("autor") String nameAutor) {

        Autor autor = this.tm.getAutor(nameAutor);
        AutorTO autorTO = this.tm.passAutorToAutorTO(autor);

        return Response.status(201).entity(autorTO).build();
    }
    @GET
    @ApiOperation(value = "get all Autor's tracks", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = TrackTO.class, responseContainer="List"),
    })
    @Path("/{autor}/tracks")//Tiene que ser /tracks sino es exactamente igual que el getAutor /autor y no los distingue
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracksAutor(@PathParam("autor") String nameAutor) {

        List<TrackTO> tracksTO = this.tm.getTracksAutor(nameAutor);
        GenericEntity<List<TrackTO>> entity = new GenericEntity<List<TrackTO>>(tracksTO) {};
        return Response.status(201).entity(entity).build();

    }
}
