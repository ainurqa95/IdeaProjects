package ru.parsentev.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ainur on 16.11.16.
 */
public class UsersTableTest {
    @Test
    public void getTableUsers() throws Exception {

        UsersTable users = new UsersTable();
        for (Users user: users.getTableUsers()
             ) {
            System.out.println(user.getFio());
        }
    }

}