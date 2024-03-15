package net.mcoto.app.controllers.person;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.mcoto.app.models.PersonModel;
import net.mcoto.app.services.IUnitWork;
import org.hibernate.id.UUIDGenerator;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

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
                LocalDateTime birthDay = person.getBirthDate().toLocalDateTime();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String birthDayFormatted = (birthDay != null) ? birthDay.format(formatter) : "";
                req.setAttribute("birthDayFormatted", birthDayFormatted);
            } else {
                person = new PersonModel();
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
            person.setId(UUID);
        } else {
            person.setId(UUID.fromString(id));
        }
        person.setDni(req.getParameter("dniPerson"));
        person.setName(req.getParameter("namePerson"));
        person.setLastName(req.getParameter("lastNamePerson"));
        // Conversión de la fecha
        String date = req.getParameter("birthDatePerson");
        LocalDate dateLocal = LocalDate.parse(date);
        var parsedDate = Timestamp.valueOf(dateLocal.atStartOfDay());
        person.setBirthDate(parsedDate);
        person.setCitizenship(req.getParameter("citizenshipPerson"));

        System.out.println("Es una insercion de " + person);

        this.unitWork.persons().saveUpdate(person);

        resp.sendRedirect("persons");

    }

}
