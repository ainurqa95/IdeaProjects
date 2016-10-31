package models;

import com.mysql.jdbc.Statement;
import com.sun.corba.se.pept.transport.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by ainur on 31.10.16.
 */
public class LifeTableDriver {
    LinkedList<LifeTable> tableLifes = new LinkedList<LifeTable>();
    Connection connection;

    public LinkedList<LifeTable> getTableLifes() {
        return tableLifes;
    }

    public LifeTableDriver(){
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Life", "root", "root");
            Statement command = (Statement) con.createStatement();
            ResultSet res = command.executeQuery("select * from mylife");
            while (res.next()) {

                LifeTable st = new LifeTable(res.getInt("id"), res.getInt("cord_i"),res.getInt("cord_j"), res.getInt("generation"));
                tableLifes.add(st);
            }

          //  command.executeUpdate("update news set title='asdf' where id_news=3");
            res.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void insert (int cord_i, cord_j, cord){
        News st = new News(id_news, title, author, short_content );
        LifeTable life_insert =new ()
        news.add(st);

        try {
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/news", "root", "root");
            Statement command = (Statement) con.createStatement();
            command.executeUpdate("update news set title='asdf' where id_news=3");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }



}
