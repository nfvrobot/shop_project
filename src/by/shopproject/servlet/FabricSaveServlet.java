package by.shopproject.servlet;

import by.shopproject.dto.FabricDto;
import by.shopproject.service.FabricService;
import by.shopproject.util.JspHelper;
import by.shopproject.validator.FabricValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fabric-save")
public class FabricSaveServlet extends HttpServlet {

    private FabricValidator fabricValidator = new FabricValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("fabric-save"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FabricDto fabricDto = FabricDto.builder()
                .name(req.getParameter("name"))
                .country(req.getParameter("country"))
                .build();
        if (!fabricValidator.isValid(fabricDto)) {
            FabricService.getInstance().save(fabricDto);
            resp.sendRedirect("/fabric-save-succ");
        } else {
            resp.sendRedirect("fabric-save");
        }
    }
}
