package ru.parsentev.servlets;

import ru.parsentev.interfaces.Category;
import ru.parsentev.models.*;
import ru.parsentev.store.CategoryStorage;
import ru.parsentev.store.ProductsStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


public class SiteServlet extends HttpServlet { // обработка главной страницы
    CategoryStorage storageCategory = new CategoryStorage(); // class Driver для категорий (работа с бд и тд)

    ProductsStorage storageProducts = new ProductsStorage();// class Driver для товаров (работа с бд и тд)



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getParameter("name")!="") {
//            String name = req.getParameter("name");
//            String reply = "Всего посещений: " + count + "в системе работали ";
//            boolean flag = false;
//            for (String str : users) {
//                if (!str.equals(name)) {
//                    reply = reply + "  " + str + ";";
//
//                } else
//                    flag = true;
//
//            }
//            if (flag)
//                reply = reply + "вы вошли в систему";
//            else {
//                users.add(name);
//                reply = reply + "вы не вошли";
//            }
//            PrintWriter pw = resp.getWriter();
//            pw.append(reply);
//            pw.flush();
//        }

        HttpSession session = req.getSession(true); // запуск сессии
        req.setAttribute("session", session);
        LinkedList<MainCategory> mainCategories = storageCategory.getMainCategory(); //  // списки категорий для headera
        LinkedList<SecondCategory> secondCategories = storageCategory.getSecondCategory(); // списки категорий для headera
        LinkedList<Products> latestProducts = storageProducts.getlatestProducts();  // списки товаров для главной страницы
        LinkedList<Products> sliderProducts = storageProducts.getProductForSlider();// списки товаров для главной slidera
        storageProducts.setPathesProductsImages(sliderProducts,1); // берем пути для картинок
        storageProducts.setPathesProductsImages(latestProducts,2); // берем пути для картинок
        LinkedList<Brands> brands = storageProducts.getBrands();
        req.setAttribute("secondCategories", secondCategories); // закидываем во view данные
        req.setAttribute("mainCategories", mainCategories);// закидываем во view данные
        req.setAttribute("latestProducts", latestProducts);// закидываем во view данные
        req.setAttribute("sliderProducts", sliderProducts);// закидываем во view данные
        req.setAttribute("brands", brands);// закидываем во view данные
        int countOfCartProducts = Cart.CountOfItemsInCart(session); // количество товаров в корзине
        req.setAttribute("countOfCartProducts", countOfCartProducts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/site/Index.jsp");
        dispatcher.forward(req, resp);

    }






    @Override
    public void destroy() {
        storageCategory.close();
        storageProducts.close();
        super.destroy();
    }
}
