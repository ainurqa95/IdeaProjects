package ru.parsentev.servlets;

import ru.parsentev.interfaces.Category;
import ru.parsentev.models.MainCategory;
import ru.parsentev.models.SecondCategory;
import ru.parsentev.store.CategoryStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by ainur on 16.11.16.
 */
public class SiteServlet extends HttpServlet {
    CategoryStorage storage = new CategoryStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        LinkedList<MainCategory> mainCategories = storage.getMainCategory();
        LinkedList<SecondCategory> secondCategories = storage.getSecondCategory();
        req.setAttribute("secondCategories", secondCategories);
        req.setAttribute("mainCategories", mainCategories);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/site/Index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        storage.close();
    }
}
