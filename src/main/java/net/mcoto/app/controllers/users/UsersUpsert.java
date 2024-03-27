package net.mcoto.app.controllers.users;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.mcoto.app.models.UserModel;
import net.mcoto.app.services.IUnitWork;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@WebServlet(name = "UserUpsertServlet", urlPatterns = {"/users-upsert"})
public class UsersUpsert extends HttpServlet {

    @Inject
    private IUnitWork unitWork;
    private Optional<UserModel> user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id == null || id.isBlank() || id.isEmpty()) {
            user = Optional.empty();
            req.setAttribute("user", new UserModel());
        } else {
            user = unitWork.users().findById(UUID.fromString(id));
            req.setAttribute("user", user.orElseThrow());
        }

        req.getRequestDispatcher("/WEB-INF/pages/users/upsert.jsp").forward(req, resp);
    }
}
