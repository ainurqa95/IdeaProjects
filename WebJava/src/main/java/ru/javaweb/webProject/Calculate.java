package ru.javaweb.webProject;

import java.util.*;

public class Calculate {
    public static void main (String[] arg){
//
//        int first = 2;
//        int second = 2;
//        int sum = first + second;
//        Calculator calc = new Calculator();
//        try {
//            calc.devide(first,second);
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            e.printStackTrace();
//        }
//        System.out.println(calc.getResult());

        Map<String,User> users = new HashMap<String,User>();
        users.put ("1", new User(1, "first"));
        users.put ("2", new User(2, "second"));
        users.put ("3", new User(1, "first"));
        for (Map.Entry<String, User> user: users.entrySet()
                ) {
            System.out.println(user.toString());
        }
       // System.out.println(users["1"].toString());


    }


}