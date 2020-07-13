package by.shopproject.servlet;

import by.shopproject.dto.ViewGuitarBasicInfoDto;
import by.shopproject.service.GuitarService;
import by.shopproject.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guitarsList")
public class GuitarsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ViewGuitarBasicInfoDto> guitars = GuitarService.getInstance().getAll();
        req.setAttribute("guitars", guitars);
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("guitars-list"))
                .forward(req, resp);
    }
}
