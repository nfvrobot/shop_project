package by.shopproject.servlet;

import by.shopproject.dto.CustomerLoginDto;
import by.shopproject.service.LoginService;
import by.shopproject.util.JspHelper;
import by.shopproject.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (!StringUtil.isEmpty(email) && !StringUtil.isEmpty(password)) {
            if (LoginService.getInstance().CustomerExist(CustomerLoginDto.builder()
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .build())) {
                req.getSession().setAttribute("currentUser", new CustomerLoginDto(email, password));
                resp.sendRedirect("/guitarsList");
            }
        } else {
            resp.sendRedirect("/login");
        }
    }
}
