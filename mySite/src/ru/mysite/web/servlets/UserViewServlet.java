package ru.mysite.web.servlets;

import ru.mysite.web.models.UsersTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ainur on 30.10.16.
 */
public class UserViewServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   super.doGet(req, resp);
       // UsersTable users = new UsersTable();
       // req.setAttribute("hello", "world");

        req.getRequestDispatcher("views/user/index.jsp").forward(req,resp);


    }
}
