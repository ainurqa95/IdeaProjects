package ru.parsentev.servlets;

import ru.parsentev.models.Users;
import ru.parsentev.store.JdbcStorage;
import ru.parsentev.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * TODO: comment
 * @author parsentev
 * @since 17.04.2015
 */
public class UserViewServlet extends HttpServlet {

	private final UserCache USER_CACHE = UserCache.getInstance();
	private JdbcStorage storage;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LinkedList<Users> users =  this.USER_CACHE.values();
		req.setAttribute("users", users);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
		dispatcher.forward(req, resp);
	}
}
