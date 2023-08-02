package io.arrogantprogrammer.beercitycode;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Register")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationResource {

    @POST
    @Transactional
    public Attendee register(Attendee attendee) {

        attendee.persist();
        return attendee;
    }

    @GET
    public List<Attendee> allAttendees() {

        return Attendee.listAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {

        Attendee attendee = Attendee.findById(id);
        if (attendee == null) {
            return Response.noContent().build();
        }else {
            return Response.ok().entity(attendee).build();
        }
    }
}
