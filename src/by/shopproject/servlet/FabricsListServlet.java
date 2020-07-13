package by.shopproject.servlet;

import by.shopproject.entity.Fabric;
import by.shopproject.service.FabricService;
import by.shopproject.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/fabric")
public class FabricsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Fabric> fabrics = FabricService.getInstance().getAll();
        req.setAttribute("fabrics", fabrics);
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("fabric"))
                .forward(req, resp);
    }

}
