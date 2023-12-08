package fca.unam.mx.resources;

import fca.unam.mx.dal.StoreDal;
import fca.unam.mx.dto.ClientDto;
import fca.unam.mx.dto.ResponseDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/clients")
public class ClientsResource {

    @Inject
    StoreDal storeDal;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all clients")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response getClients() {
        ResponseDto responseDto = storeDal.getClients();
        return Response.ok(responseDto).build();
    }
}
