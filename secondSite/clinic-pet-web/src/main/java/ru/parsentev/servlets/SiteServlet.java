package ru.parsentev.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ainur on 16.11.16.
 */
public class SiteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/site/Index.jsp");
        dispatcher.forward(req, resp);
    }
}
