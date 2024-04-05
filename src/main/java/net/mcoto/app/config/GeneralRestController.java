package net.mcoto.app.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import net.mcoto.app.models.PersonModel;
import net.mcoto.app.models.RoleModel;
import net.mcoto.app.models.UserModel;
import net.mcoto.app.services.IUnitWork;

import java.util.List;


@Path("data")
@Produces(MediaType.APPLICATION_JSON)
public class GeneralRestController {

    @Inject
    private IUnitWork unitWork;

    @GET
    @Path("/getAllPersons")
    public Response getAllPerson() {

        try {
            List<PersonModel> persons = unitWork.persons().getAll();
            return Response.ok(persons).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/getAllUsers")
    public List<UserModel> getAllUsers() {
        return unitWork.users().getAll();
    }

    @GET
    @Path("/getAllRoles")
    public List<RoleModel> getAllRoles() {
        return unitWork.roles().getAll();
    }

}
