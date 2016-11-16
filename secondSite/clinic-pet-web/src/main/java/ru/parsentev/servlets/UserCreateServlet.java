package ru.parsentev.servlets;

import ru.parsentev.models.User;
import ru.parsentev.models.Users;
import ru.parsentev.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO: comment
 * @author parsentev
 * @since 17.04.2015
 */
public class UserCreateServlet extends HttpServlet {


	private final UserCache USER_CACHE = UserCache.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = this.USER_CACHE.add(new Users(req.getParameter("fio"), req.getParameter("login"), "passw",1));
		//this.USER_CACHE.add(new Users(USER_CACHE.generateId(), req.getParameter("fio"), req.getParameter("login")));
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
	}
}
