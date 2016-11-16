package ru.parsentev.store;

import ru.parsentev.interfaces.ProductsInterface;
import ru.parsentev.models.MainCategory;
import ru.parsentev.models.Products;
import ru.parsentev.models.SecondCategory;
import ru.parsentev.service.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by ainur on 16.11.16.
 */
public class ProductsStorage implements ProductsInterface {

    private final Connection connection;

    LinkedList<Products> products ;


    public ProductsStorage() {
        this.products= new LinkedList<>();

        final Settings settings = Settings.getInstance();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList<Products> getlatestProducts() {
        return null;
    }

    @Override
    public LinkedList<Products> getBrands() {
        return null;
    }

    @Override
    public LinkedList<Products> getAllProducts() {
        return null;
    }

    @Override
    public LinkedList<Products> getProductForSlider() {
        return null;
    }

    @Override
    public LinkedList<Products> getSecondCatProducts(int idSecondCat) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public void updatePruduct(Products product) {

    }

    @Override
    public int AddProduct(Products product) {
        return 0;
    }

    @Override
    public int getCountOfProducts(int idSecondCat) {
        return 0;
    }

    @Override
    public Products getProductById(int id) {
        return null;
    }
}
