package ru.javaweb.app;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by ainur on 24.10.16.
 */
public class UserTest {

    @Test
    public void Reflexive (){
        User user = new User(1, "hey");
        Assert.assertEquals(user, user);


    }
    @Test
    public void Simmetric (){
        User user1 = new User(1, "hey");
        User user2 = new User(1, "hey");
        Assert.assertEquals(user1, user2);
        Assert.assertEquals(user2, user1);

    }
    @Test
    public void Consistant (){
        User user1 = new User(1, "hey");
        User user2 = new User(1, "hey");
        for (int i = 0; i < 10; i++) {

        }
        Assert.assertEquals(user2, user1);

    }
    @Test
    public void Transitive (){
        User user1 = new User(1, "hey");
        User user2 = new User(1, "hey");
        User user3 = new User(1, "hey");
        Assert.assertEquals(user1, user2);
        Assert.assertEquals(user2, user3);
        Assert.assertEquals(user1, user3);

    }
    @Test
    public void MapPut (){
        Map<User,User> users = new HashMap<User,User>();
        users.put (new User(1, "first"), new User(1, "first"));
        users.put (new User(2, "second"), new User(2, "second"));
        users.put (new User(1, "first"), new User(3, "first"));
        Assert.assertEquals(2,users.size());

    }
    @Test
    public void arrayConsist (){
        List<User> users = new ArrayList<User>();
        users.add ( new User(1, "first"));
        users.add ( new User(2, "second"));
        users.add ( new User(1, "first"));
        Assert.assertTrue(users.contains(new User(1, "first")));

    }
    @Test
    public void mapCosnsist (){
        Map<String,User> users = new HashMap<String,User>();
        users.put ("1", new User(1, "first"));
        users.put ("2", new User(2, "second"));
        users.put ("3", new User(1, "first"));
        User ainur = users.get("1");
        Assert.assertEquals(new User(1, "first"),ainur);

    }



}