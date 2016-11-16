package ru.mysite.web.servlets;

import ru.mysite.web.models.Users;
import ru.mysite.web.store.CacheUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ainur on 09.11.16.
 */
public class UserUpdateServlet extends HttpServlet {
    private final CacheUser USER_CACHE = CacheUser.getInstance();
    final AtomicInteger ids = new AtomicInteger();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user", this.USER_CACHE.get(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserUpdate.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.USER_CACHE.edit(new Users(this.ids.incrementAndGet(), req.getParameter("fio"), req.getParameter("login"), req.getParameter("password")));
        req.setAttribute("users", this.USER_CACHE.values());

        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));

    }
}
