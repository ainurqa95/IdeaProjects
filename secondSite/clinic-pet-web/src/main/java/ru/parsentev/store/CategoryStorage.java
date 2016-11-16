package ru.parsentev.store;

import ru.parsentev.models.MainCategory;
import ru.parsentev.models.SecondCategory;
import ru.parsentev.service.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by ainur on 16.11.16.
 */
public  class CategoryStorage {
    private final Connection connection;

    LinkedList<MainCategory> mainCategory;
    LinkedList<SecondCategory> secondCategory;

    public CategoryStorage() {
        final Settings settings = Settings.getInstance();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));


        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
