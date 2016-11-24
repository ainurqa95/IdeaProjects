package ru.parsentev.servlets;

import ru.parsentev.garbage.Users;
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
public class UserEditServlet extends HttpServlet {

	final AtomicInteger ids = new AtomicInteger();

	private static final UserCache USER_CACHE = UserCache.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users selectedUser = this.USER_CACHE.get(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("user", selectedUser);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/EditUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Users user = new Users(id, req.getParameter("fio"), req.getParameter("login"), "password", 1);
		this.USER_CACHE.edit(user);
		req.setAttribute("users", this.USER_CACHE.values());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
		dispatcher.forward(req, resp);
	}
}
