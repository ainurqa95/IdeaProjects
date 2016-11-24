package ru.parsentev.store;

import ru.parsentev.models.MainCategory;
import ru.parsentev.models.SecondCategory;
import ru.parsentev.service.Settings;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by ainur on 16.11.16.
 */
public  class CategoryStorage  {
    private final Connection connection;

    LinkedList<MainCategory> mainCategory ;
    LinkedList<SecondCategory> secondCategory;

    public CategoryStorage() {
        this.mainCategory= new LinkedList<>();
        this.secondCategory = new LinkedList<>();
        final Settings settings = Settings.getInstance();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));



        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
    public LinkedList<MainCategory> getMainCategory() {

         try (final Statement statement = this.connection.createStatement();
              final ResultSet rs = statement.executeQuery("select * from main_category")){
            while (rs.next()) {
                System.out.println(rs.getString("name"));
               this.mainCategory.add(new MainCategory(rs.getInt("idmain_cat"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  this.mainCategory;
    }
    public LinkedList<SecondCategory> getSecondCategory() {

        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from second_category")) {
            while (rs.next()) {

                this.secondCategory.add(new SecondCategory(rs.getInt("idsecond_cat"),rs.getInt("main_category_idmain_cat"),rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  this.secondCategory;
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
