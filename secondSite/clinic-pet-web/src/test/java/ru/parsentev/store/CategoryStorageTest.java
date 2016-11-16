package ru.parsentev.store;

import org.junit.Test;
import ru.parsentev.models.MainCategory;
import ru.parsentev.models.SecondCategory;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by ainur on 16.11.16.
 */
public class CategoryStorageTest {
    @Test
    public void test(){
        CategoryStorage storage = new CategoryStorage();
        LinkedList<MainCategory> mainCategories = storage.getMainCategory();
        for (MainCategory cat: mainCategories
             ) {
            System.out.println(cat.getName());
        }
        storage.close();

    }
    @Test
    public void test2(){
        CategoryStorage storage = new CategoryStorage();
        LinkedList<SecondCategory> secCategories = storage.getSecondCategory();
        for (SecondCategory cat: secCategories
                ) {
            System.out.println(cat.getName());
        }


    }

}