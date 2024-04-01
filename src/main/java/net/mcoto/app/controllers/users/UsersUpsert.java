package net.mcoto.app.controllers.users;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.mcoto.app.models.PersonModel;
import net.mcoto.app.models.UserModel;
import net.mcoto.app.services.IUnitWork;
import net.mcoto.app.utils.ToastAlerts;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@WebServlet(name = "UserUpsertServlet", urlPatterns = {"/users-upsert"})
public class UsersUpsert extends HttpServlet {

    @Inject
    private IUnitWork unitWork;
    private Optional<UserModel> user;

    private ToastAlerts toastAlerts = new ToastAlerts();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        List<PersonModel> persons = unitWork.persons().getAll();
        if (id == null || id.isBlank() || id.isEmpty()) {
            user = Optional.empty();
            req.setAttribute("user", new UserModel());
            req.setAttribute("persons", persons);
        } else {
            user = unitWork.users().findById(UUID.fromString(id));
            req.setAttribute("user", user.orElseThrow());
            req.setAttribute("persons", persons);
        }

        req.getRequestDispatcher("/WEB-INF/pages/users/upsert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel user = new UserModel();
        String id = req.getParameter("userId");
        if (id != null && !id.isBlank() && !id.isEmpty()) {
            //se trata de una actualizcion
            user = getUserToSave(req);
            user.setId(UUID.fromString(id));
            toastAlerts.INFO("Se ha actualizado el usuario");
            req.setAttribute("alerts", toastAlerts);
            unitWork.users().saveUpdate(user);
        } else {
            //se trata de una creacion
            user = getUserToSave(req);
            toastAlerts.SUCCESS("Se ha creado el usuario");
            req.setAttribute("alerts", toastAlerts);
            unitWork.users().save(user);
        }
        System.out.println(user.getId() + " " + user.getUserName() + " " + user.getEmail() + " " + user.getPassword() + " " + user.getPerson().getName());
        resp.sendRedirect("users");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("id");
        Optional<UserModel> user = unitWork.users().findById(UUID.fromString(userId));
        if (user.isPresent()) {
            System.out.println("Se eliminara al usuario" + user.get().getUserName());
            unitWork.users().delete(user.get());
        }

    }


    private UserModel getUserToSave(HttpServletRequest req) {

        PersonModel person = null;
        UserModel user = new UserModel();
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password1"));
        String isActive = req.getParameter("isActive");
        user.setActive(isActive != null);
        person = unitWork.persons().findById(UUID.fromString(req.getParameter("personId"))).orElseThrow();
        user.setIdPerson(person.getId());
        user.setPerson(person);

        return user;
    }

}
