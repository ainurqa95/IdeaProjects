package ru.ainur.servlets;
import interfaces.Pet;
import models.Animal;
import models.Dog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClinicServlet extends HttpServlet {
    final  List<Pet> pets  = new CopyOnWriteArrayList<Pet>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("ok answer form simple servlet");

        /*resp.setContentType("text/html");
   /     PrintWriter writer= resp.getWriter();
        writer.append("<!DOCTYPE html>"
+"<html>"
+"<head>"
+"<title> Навек</title>"

+"</head>"
+"<body>"
               // +"<form method='post' action='"+ req.getContextPath()+"' >"
                +"<input name ='petName' class=''  value='' type='text'>"
                +" <input type = 'submit'  name = 'save' value='Сохранить' >"

//+"</form>"
               // +this.viewPets()
+"</body>"
+"</html>");

        writer.flush();
        */
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.pets.add(new Dog(new Animal(req.getParameter("petName"))));
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
