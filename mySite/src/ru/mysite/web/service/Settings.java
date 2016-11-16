package ru.mysite.web.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ainur on 13.11.16.
 */
public class Settings {
    private static final Settings INSTANCE = new Settings(); // создаем объект класса который потом передаем геттером
    private final Properties properties = new Properties();
    public static Settings getINSTANCE() {

        return INSTANCE;
    }
    private Settings(){
        try {
         //   properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("ru.mysite.web.resources/mysite.properties").getFile()));
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("ru/mysite/web/resources/mysite.properties").getFile()));
            // считываем наши настройк бд
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public String value (String key){

    return this.properties.getProperty(key); // получаем например пароль или ip или логин

    }
}

