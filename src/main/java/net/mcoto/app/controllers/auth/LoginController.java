package net.mcoto.app.controllers.auth;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.mcoto.app.models.UserModel;
import net.mcoto.app.services.IUnitWork;
import net.mcoto.app.utils.BCryptManager;
import net.mcoto.app.utils.PN;
import net.mcoto.app.utils.ToastAlerts;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -8408293917989299183L;
	ToastAlerts toastAlerts = null;
	@Inject
	private IUnitWork unitWork;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("pageParams", PN.LOGIN.getModel());
		req.getRequestDispatcher("/WEB-INF/pages/layout.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userOrEmail = req.getParameter("username");
		String password = req.getParameter("password");
		if (checkCredentials(userOrEmail, password)) {
			toastAlerts = new ToastAlerts();
			toastAlerts.setSUCCESS("Bienvenido " + userOrEmail);
			req.setAttribute("alerts", toastAlerts);
			req.setAttribute("pageParams", PN.MAIN.getModel());
			req.getRequestDispatcher("/WEB-INF/pages/layout.jsp").forward(req, resp);
		} else {
			toastAlerts = new ToastAlerts();
			toastAlerts.setERROR("Credenciales incorrectas");
			req.setAttribute("pageParams", PN.LOGIN.getModel());
			req.setAttribute("alerts", toastAlerts);
			req.getRequestDispatcher("/WEB-INF/pages/layout.jsp").forward(req, resp);
		}

	}

	private boolean checkCredentials(String userOrEmail, String password) {

		UserModel user = new UserModel();

		if (userOrEmail.contains("@")) {
			user = unitWork.users().findByFieldName("email", userOrEmail).getFirst();
			if (user == null) {
				return false;
			} else {
				return BCryptManager.checkPassword(password, user.getPassword());
			}
		} else {
			user = unitWork.users().findByFieldName("userName", userOrEmail).getFirst();
			if (user == null) {
				return false;
			} else {
				return BCryptManager.checkPassword(password, user.getPassword());
			}
		}

	}
}
