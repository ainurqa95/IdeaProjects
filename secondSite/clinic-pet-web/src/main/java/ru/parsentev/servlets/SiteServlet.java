package ru.parsentev.servlets;

import ru.parsentev.interfaces.Category;
import ru.parsentev.models.Brands;
import ru.parsentev.models.MainCategory;
import ru.parsentev.models.Products;
import ru.parsentev.models.SecondCategory;
import ru.parsentev.store.CategoryStorage;
import ru.parsentev.store.ProductsStorage;

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
    CategoryStorage storageCategory = new CategoryStorage();
    ProductsStorage storageProducts = new ProductsStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        LinkedList<MainCategory> mainCategories = storageCategory.getMainCategory();
        LinkedList<SecondCategory> secondCategories = storageCategory.getSecondCategory();
        LinkedList<Products> latestProducts = storageProducts.getlatestProducts();
        LinkedList<Products> sliderProducts = storageProducts.getProductForSlider();
        storageProducts.setPathesProductsImages(sliderProducts,1);
        storageProducts.setPathesProductsImages(latestProducts,1);
//        setPathesProductsImages(sliderProducts,storageProducts,1);
//        setPathesProductsImages(latestProducts,storageProducts,2);
        LinkedList<Brands> brands = storageProducts.getBrands();
        req.setAttribute("secondCategories", secondCategories);
        req.setAttribute("mainCategories", mainCategories);
        req.setAttribute("latestProducts", latestProducts);
        req.setAttribute("sliderProducts", sliderProducts);
        req.setAttribute("brands", brands);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/site/Index.jsp");
        dispatcher.forward(req, resp);
    }






    @Override
    public void destroy() {
        super.destroy();
        storageCategory.close();
        storageProducts.close();
    }
}
