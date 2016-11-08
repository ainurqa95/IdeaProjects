package ru.mysite.web.servlets;

import ru.mysite.web.models.Users;
import ru.mysite.web.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ainur on 30.10.16.
 */
public class UserCreateServlet extends HttpServlet{
    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.USER_CACHE.add(new Users(USER_CACHE.generateId(),req.getParameter("fio"), req.getParameter("login"), req.getParameter("password")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}
