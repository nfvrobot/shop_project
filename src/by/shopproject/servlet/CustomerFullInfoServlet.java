package by.shopproject.servlet;

import by.shopproject.dto.ViewCustomerFullInfoDto;
import by.shopproject.service.CustomerService;
import by.shopproject.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer-full-info")
public class CustomerFullInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            ViewCustomerFullInfoDto customerFullInfoDto = CustomerService.getInstance().getById(Integer.valueOf(id));
            req.setAttribute("customer", customerFullInfoDto);
            getServletContext()
                    .getRequestDispatcher(JspHelper.getPath("customer-full-info"))
                    .forward(req, resp);
        }
    }
}
