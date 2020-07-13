package by.shopproject.servlet;

import by.shopproject.dto.CreateNewCustomerDto;
import by.shopproject.service.CustomerService;
import by.shopproject.util.JspHelper;
import by.shopproject.validator.CustomerValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer-save")
public class CustomerSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("customer-save"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewCustomerDto customerDto = CreateNewCustomerDto.builder()
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .phone(req.getParameter("phone"))
                .address(req.getParameter("address"))
                .build();
        if (!customerValidator.isValid(customerDto)) {
            CustomerService.getInstance().save(customerDto);
            resp.sendRedirect("/customer-save-succ");
        } else {
            resp.sendRedirect("/customer-save");
        }
    }

    private CustomerValidator customerValidator = new CustomerValidator();
}
