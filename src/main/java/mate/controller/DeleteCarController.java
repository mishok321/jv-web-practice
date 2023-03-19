package mate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.service.CarService;

@WebServlet(urlPatterns = "/cars/delete")
public class DeleteCarController extends HttpServlet {
    private static final Injector injector
            = Injector.getInstance("mate");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        CarService carService = (CarService) injector.getInstance(CarService.class);
        Long id = Long.parseLong(req.getParameter("id"));
        carService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
