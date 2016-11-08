package ru.javaweb.webProject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by ainur on 24.10.16.
 */
public class UserRunner {

    public static void main (String[] arg){
            List<User> users = new LinkedList<User>();
            users.add (new User(1, "first"));
             users.add (new User(2, "second"));
            users.add (new User(1, "first"));
        for (User user: users
             ) {
            System.out.println(user.toString());
        }
    }

}
