package net.mcoto.app.controllers.person;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import jakarta.ws.rs.Path;
import net.mcoto.app.models.PersonModel;
import net.mcoto.app.services.IUnitWork;

@WebServlet(name = "PersonController", urlPatterns = "/persons")
public class PersonControllers extends HttpServlet {

    @Inject
    private IUnitWork unitWork;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<PersonModel> persons = unitWork.persons().getAll();
        System.out.println("Cargando listado de personas" + persons);
        req.setAttribute("persons", persons);
        System.out.println("ESTA ES NOOOO POST-BACK");
        req.getRequestDispatcher("/WEB-INF/pages/persons/persons-view.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<PersonModel> persons = unitWork.persons().getAll();
        String json = new Gson().toJson(persons);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Path("/persons/getAllPersons")
    public String getAllPersons() {
        List<PersonModel> persons = unitWork.persons().getAll();
        // String json = new Gson().toJson(persons);
        return new Gson().toJson(persons);
    }
}
