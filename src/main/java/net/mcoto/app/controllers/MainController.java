package net.mcoto.app.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.mcoto.app.models.PersonModel;
import net.mcoto.app.models.RoleModel;
import net.mcoto.app.models.UserModel;
import net.mcoto.app.models.UserRoleModel;
import net.mcoto.app.services.IUnitWork;
import net.mcoto.app.utils.BCryptManager;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainController extends HttpServlet {

    @Inject
    private IUnitWork unitWork;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Configuracion inicial en caso de no haber un usuario administrador y roles definidos
        if (unitWork.users().getAll().isEmpty() && unitWork.roles().getAll().isEmpty()) {

            //Persona generica de administracion
            PersonModel person = new PersonModel();
            person.setDni("##-####-0001");
            person.setName("Admin");
            person.setLastName("Admin");
            person.setCitizenship("Usa");
            person.setBirthDate(new Timestamp(System.currentTimeMillis()));
            unitWork.persons().saveUpdate(person);

            UserModel user = new UserModel();
            user.setUserName("admin");
            user.setEmail("admin");
            user.setPassword(BCryptManager.hashPassword("admin.ecomm"));
            user.setActive(true);
            user.setPerson(unitWork.persons().findByFieldName("dni", "##-####-0001").getFirst());
            unitWork.users().saveUpdate(user);

            RoleModel rolAmin = new RoleModel();
            rolAmin.setRoleName("ADMIN");
            rolAmin.setRoleDescription("Administrator full access");
            rolAmin.setActive(true);
            unitWork.roles().saveUpdate(rolAmin);

            //Role empleado
            RoleModel rolEmp = new RoleModel();
            rolEmp.setRoleName("EMPLOYEE");
            rolEmp.setRoleDescription("Employee access limited for work operations");
            rolEmp.setActive(true);
            unitWork.roles().saveUpdate(rolEmp);

            //Role de cliente
            RoleModel rolClient = new RoleModel();
            rolClient.setRoleName("CLIENT");
            rolClient.setRoleDescription("Client access limited for shopping operations");
            rolClient.setActive(true);
            unitWork.roles().saveUpdate(rolClient);

            //Asignar rol admin a usuario admin
            UserRoleModel userRole = new UserRoleModel();
            userRole.setIdUser(user.getId());
            userRole.setIdRole(rolAmin.getId());
            unitWork.userRoles().saveUpdate(userRole);


        }

        req.getRequestDispatcher("/WEB-INF/pages/main-view.jsp").forward(req, resp);
    }
}
