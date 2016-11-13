package ru.mysite.web.servlets;

import ru.mysite.web.models.Users;
import ru.mysite.web.models.UsersTable;
import ru.mysite.web.store.CacheUser;
import ru.mysite.web.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Created by ainur on 30.10.16.
 */
public class UserViewServlet extends HttpServlet{

    private final CacheUser USER_CACHE = CacheUser.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        LinkedList <String> users = new LinkedList<>();

        req.setAttribute("users", this.USER_CACHE.values());
       RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserIndex.jsp");
       dispatcher.forward(req,resp);


    }
}
