package models;

import com.sun.corba.se.pept.transport.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



/**
 * Created by ainur on 04.11.16.
 */
public class UsersTable {
    LinkedList<Users> tableUsers = new LinkedList<Users>();
    Connection connection;

    public LinkedList<Users> getTableUsers() {
        return tableUsers;
    }

    public UsersTable(){
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Life", "root", "root");
            Statement command = (Statement) con.createStatement();
            ResultSet res = command.executeQuery("select * from users");
            while (res.next()) { // берем все элементы из таблицы

                Users st = new Users(res.getInt("id"), res.getString("fio"),res.getString("login"));
                tableUsers.add(st);
            }

            res.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Users getUserByLogin (String login){
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Life", "root", "root");
            Statement command = (Statement) con.createStatement();
            ResultSet res = command.executeQuery("select * from users where login ="+ login +"");
            Users user = new Users(res.getInt("id"), res.getString("fio"),res.getString("login"));
            res.close();
            con.close();
            return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void insert (String fio, String login){
        Users st = new Users(fio, login );
        tableUsers.add(st);
        try {
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Life", "root", "root");
            com.mysql.jdbc.Statement command = (com.mysql.jdbc.Statement) con.createStatement();
            // command.executeUpdate("update news set title='asdf' where id_news=3");
            command.execute("insert into users (fio, login)  values ("+fio+",+"+login+")");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
