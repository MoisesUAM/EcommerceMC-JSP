package net.mcoto.app.controllers;

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

@WebServlet(name = "PersonController", urlPatterns = "/persons")
public class PersonControllers extends HttpServlet {

    @Inject
    private IUnitWork unitWork;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PersonModel> persons = unitWork.persons().getAll();
        req.setAttribute("persons", persons);
        req.getRequestDispatcher("/WEB-INF/pages/persons-view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
