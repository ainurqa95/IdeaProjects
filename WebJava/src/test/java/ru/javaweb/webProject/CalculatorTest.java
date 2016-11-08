package ru.javaweb.webProject;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ainur on 23.10.16.
 */
public class CalculatorTest {
    @Test
    public void devide() throws Exception {
        Calculator calc = new Calculator();
        calc.devide(4,2);
        Assert.assertEquals(2, calc.getResult());

    }

    @Test
    public void add() throws Exception {
        Calculator calc = new Calculator();
        calc.add(1,2);
        Assert.assertEquals(3, calc.getResult() );// проверяем равны ли два числа
    }

}