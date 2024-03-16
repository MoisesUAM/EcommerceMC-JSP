package net.mcoto.app.controllers.person;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import net.mcoto.app.models.PersonModel;
import net.mcoto.app.services.IUnitWork;
import org.apache.logging.log4j.core.appender.routing.Route;

@WebServlet(name = "PersonController", urlPatterns = "/persons")
public class PersonControllers extends HttpServlet {

    @Inject
    private IUnitWork unitWork;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PersonModel> persons = unitWork.persons().getAll();
        System.out.println("Cargando listado de personas" + persons);
        req.setAttribute("persons", persons);

        req.getRequestDispatcher("/WEB-INF/pages/persons/persons-view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
