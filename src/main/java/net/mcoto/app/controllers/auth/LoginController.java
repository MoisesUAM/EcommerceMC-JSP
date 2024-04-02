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
import net.mcoto.app.utils.ToastAlerts;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    private final ToastAlerts toastAlerts = new ToastAlerts();
    @Inject
    private IUnitWork unitWork;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/pages/auth/login-view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userOrEmail = req.getParameter("username");
        String password = req.getParameter("password");
        if (checkCredentials(userOrEmail, password)) {
            toastAlerts.SUCCESS("Login correcto");
            req.setAttribute("alerts", toastAlerts);
            req.getRequestDispatcher("/WEB-INF/pages/main-view.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/pages/auth/login-view.jsp").forward(req, resp);
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
