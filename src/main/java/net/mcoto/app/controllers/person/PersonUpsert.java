package net.mcoto.app.controllers.person;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.mcoto.app.models.PersonModel;
import net.mcoto.app.services.IUnitWork;

@WebServlet(name = "PersonUpsert", urlPatterns = "/persons-upsert")
public class PersonUpsert extends HttpServlet {

    @Inject
    private IUnitWork unitWork;

    private PersonModel person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null || id.isBlank() || id.isEmpty()) {
            person = new PersonModel();
        } else {
            Optional<PersonModel> optPerson = unitWork.persons().findById(UUID.fromString(id));
            if (optPerson.isPresent()) {
                person = optPerson.orElseThrow();
            }
        }

        req.setAttribute("person", person);

        req.getRequestDispatcher("/WEB-INF/pages/persons/upsert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idPerson");

        if (id == null || id.isBlank() || id.isEmpty()) {

            person = new PersonModel();
            person.setDni(req.getParameter("dniPerson"));
            person.setName(req.getParameter("namePerson"));
            person.setLastName(req.getParameter("lastNamePerson"));
            // Conversión de la fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = null;
            try {
                parsedDate = dateFormat.parse(req.getParameter("birthDatePerson"));
            } catch (ParseException ex) {
                Logger.getLogger(PersonUpsert.class.getName()).log(Level.SEVERE, null, ex);
            }
            person.setBirthDate(parsedDate);
            person.setCitizenship(req.getParameter("citizenshipPerson"));

            System.out.println("Es una insercion de " + person);

            this.unitWork.persons().save(person);

            resp.sendRedirect("persons");
        }
    }

}
