package ru.mysite.web.servlets;

import ru.mysite.web.store.CacheUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ainur on 09.11.16.
 */
public class UserDeleteServlet extends HttpServlet {

    private final CacheUser USER_CACHE = CacheUser.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.USER_CACHE.delete(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("users", this.USER_CACHE.values());
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}
