package net.mcoto.app.controllers.person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PersonController", urlPatterns = "/persons")
public class PersonControllers extends HttpServlet {

    private static final long serialVersionUID = -1705433496016771662L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ESTA ES NOOOO POST-BACK");
        req.getRequestDispatcher("/WEB-INF/pages/persons/persons-view.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
