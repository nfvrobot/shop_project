package by.shopproject.servlet;

import by.shopproject.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guitar-save-succ")
public class GuitarSuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext()
                .getRequestDispatcher(JspHelper.getPath("guitar-save-succ"))
                .forward(req, resp);
    }
}
