package ru.mysite.web.servlets;
import ru.mysite.web.interfaces.Pet;
import ru.mysite.web.models.Animal;
import ru.mysite.web.models.Dog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ainur on 28.10.16.
 */
public class SimpleServlet extends HttpServlet {
    final List<Pet> pets  = new CopyOnWriteArrayList<Pet>();
    private String label;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("views/ab.jsp").forward(req,resp);

/*
        resp.setContentType("text/html");
        PrintWriter writer= resp.getWriter();
        writer.append("<!DOCTYPE html>"
+"<html>"
+"<head>"
                +"<meta charset='utf-8' />"
+"<title> Клиника</title>"

+"</head>"
+"<body>"
                +"<form method='post' action='"+ req.getContextPath()+"' >"
                +"<input name ='petName' class=''  value='' type='text'>"
                +" <input type = 'submit'  name = 'save' value='Сохранить' >"

+"</form>"
                + this.label
                +this.viewPets()
+"</body>"
+"</html>");

        writer.flush();
        */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        this.pets.add(new Dog(new Animal(req.getParameter("petName"))));

        this.label = req.getParameter("petName");

        doGet(req,resp);
    }
    private String viewPets(){
        StringBuilder sb = new StringBuilder();
        sb.append("<p> Pets </p>");
        sb.append("<table style = 'border: 1px solid red'>");

        for (Pet pet: pets
                ) {
            sb.append("<tr> <td style = 'border: 1px solid red' >");
            sb.append (pet.getName() );
            sb.append("</td> </tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

}
