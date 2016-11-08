package sample.models;

import com.mysql.jdbc.Statement;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Айнур on 25.10.2016.
 */
public class NewsDriver {
        LinkedList<News> news = new LinkedList<News>();
        Connection connection;

    public LinkedList<News> getNews() {
        return news;
    }

    public NewsDriver() {
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/news", "root", "root");
            Statement command = (Statement) con.createStatement();
            ResultSet res = command.executeQuery("select * from news");
            while (res.next()) {
                System.out.println("" + res.getString("title"));
                News st = new News(res.getInt("id_news"), res.getString("title"),res.getString("author"), res.getString("short_content"));
                news.add(st);
            }

            command.executeUpdate("update news set title='asdf' where id_news=3");
            res.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void insert (int id_news, String title, String author, String short_content ){
        News st = new News(id_news, title, author, short_content );
        news.add(st);
        try {
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/news", "root", "root");
            Statement command = (Statement) con.createStatement();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
