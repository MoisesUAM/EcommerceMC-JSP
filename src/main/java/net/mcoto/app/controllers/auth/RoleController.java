package net.mcoto.app.controllers.auth;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.mcoto.app.models.RoleModel;
import net.mcoto.app.services.IUnitWork;
import net.mcoto.app.utils.PN;
import net.mcoto.app.utils.ToastAlerts;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "RoleController", value = "/role")
public class RoleController extends HttpServlet {

	private static final long serialVersionUID = 7414593857172993824L;
	@Inject
	private IUnitWork unitWork;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("pageParams", PN.ROLE.getModel());
		req.getRequestDispatcher("/WEB-INF/pages/layout.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("roleId");
		RoleModel rol = new RoleModel();
		if (id != null && !id.isBlank() && !id.isEmpty()) {
			// Se trata de una actualización
			rol = roleToSaveOrUpdate(req);
			rol.setId(UUID.fromString(id));

			unitWork.roles().saveUpdate(rol);
		} else {
			// Se trata de una creación
			rol = roleToSaveOrUpdate(req);
			unitWork.roles().saveUpdate(rol);
		}

		resp.sendRedirect("role");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		if (id != null && !id.isBlank() && !id.isEmpty()) {
			System.out.println(id);
			resp.sendRedirect("role");
		}
	}

	private RoleModel roleToSaveOrUpdate(HttpServletRequest req) {
		RoleModel rol = new RoleModel();
		rol.setRoleName(req.getParameter("roleName"));
		rol.setRoleDescription(req.getParameter("roleDescription"));
		String isActive = req.getParameter("roleActive");
		rol.setActive(isActive != null);

		return rol;
	}
}
