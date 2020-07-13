package by.shopproject.servlet;

import by.shopproject.dto.CreateNewGuitarDto;
import by.shopproject.entity.Color;
import by.shopproject.service.FabricService;
import by.shopproject.service.GuitarService;
import by.shopproject.util.JspHelper;
import by.shopproject.validator.GuitarValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createGuitar")
public class GuitarCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("fabrics", FabricService.getInstance().getAll());
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("guitar-save"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewGuitarDto guitarDto = CreateNewGuitarDto.builder()
                .fabricId(Integer.valueOf(req.getParameter("fabricId")))
                .name(req.getParameter("name"))
                .strings(Short.valueOf(req.getParameter("strings")))
                .color(Color.valueOf(req.getParameter("color")))
                .count(Integer.valueOf(req.getParameter("count")))
                .build();
        if (!guitarValidator.isValid(guitarDto)) {
            GuitarService.getInstance().save(guitarDto);
            resp.sendRedirect("/guitar-save-succ");
        } else {
            resp.sendRedirect("/createGuitar");
        }
    }

    private GuitarValidator guitarValidator = new GuitarValidator();
}
