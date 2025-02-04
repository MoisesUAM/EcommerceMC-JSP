package net.mcoto.app.config;

import java.util.List;

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

@Path("data")
@Produces(MediaType.APPLICATION_JSON)
public class GeneralRestController {

	@Inject
	private IUnitWork unitWork;

	@GET
	@Path("/getAllPersons")
	public Response getAllPerson() {

		try {
			List<PersonModel> persons = unitWork.persons().getAll().stream()
					.filter(p -> !p.getDni().equals("##-####-0001")).toList();
			return Response.ok(persons).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/getAllUsers")
	public Response getAllUsers() {
		try {
			List<UserModel> users = unitWork.users().getAll();
			return Response.ok(users).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/getAllRoles")
	public Response getAllRoles() {
		try {
			List<RoleModel> roles = unitWork.roles().getAll();
			return Response.ok(roles).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

}
