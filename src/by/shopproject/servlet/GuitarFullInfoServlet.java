package by.shopproject.servlet;

import by.shopproject.dto.GuitarBuyDto;
import by.shopproject.dto.ViewGuitarFullInfoDto;
import by.shopproject.entity.Status;
import by.shopproject.service.GuitarService;
import by.shopproject.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guitarFullInfo")
public class GuitarFullInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            ViewGuitarFullInfoDto guitarFullInfoDto = GuitarService.getInstance().getById(Integer.valueOf(id));
            req.setAttribute("guitar", guitarFullInfoDto);
            getServletContext()
                    .getRequestDispatcher(JspHelper.getPath("guitar-full-info"))
                    .forward(req, resp);
        }
    }
}
