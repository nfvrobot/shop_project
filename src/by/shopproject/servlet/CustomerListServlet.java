package by.shopproject.servlet;

import by.shopproject.dao.CustomerDao;
import by.shopproject.entity.Customer;
import by.shopproject.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customers")
public class CustomerListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = CustomerDao.getInstance().getAll();
        req.setAttribute("customers", customers);
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("customers-list"))
                .forward(req, resp);
    }
}
