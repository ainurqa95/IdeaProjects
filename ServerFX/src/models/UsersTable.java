package models;

import com.sun.corba.se.pept.transport.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;


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

                Users st = new Users(res.getInt("id"), res.getString("fio"),res.getString("login"), res.getString("password"));
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
            ResultSet res = command.executeQuery("select * from users where login ='"+login+"'");
            Users user;
            while (res.next()) { // берем все элементы из таблицы

                user = new Users(res.getInt("id"), res.getString("fio"),res.getString("login"), res.getString("password"));

                return user;
                //  tableUsers.add(user);
            }
            res.close();
            con.close();
            //return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void insert (String fio, String login, String password){
        Users st = new Users(fio, login , password);
        tableUsers.add(st);
        try {
            Properties properties=new Properties();
            properties.setProperty("user","root");
            properties.setProperty("password","root");
            properties.setProperty("useUnicode","true");
            properties.setProperty("characterEncoding","UTF-8");
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Life", properties);
            com.mysql.jdbc.Statement command = (com.mysql.jdbc.Statement) con.createStatement();
            command.execute("insert into users (fio, login, password)  values ('"+fio+"','"+login+"','"+password+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public Users getUserByID (String ID){
        try {
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Life", "root", "root");
            Statement command = (Statement) con.createStatement();
            ResultSet res = command.executeQuery("select * from users where id ='"+ID+"'");
            Users user;
            while (res.next()) { // берем все элементы из таблицы

                user = new Users(res.getInt("id"), res.getString("fio"),res.getString("login"), res.getString("password"));

                return user;
                //  tableUsers.add(user);
            }
            res.close();
            con.close();
            //return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
