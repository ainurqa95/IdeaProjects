package ru.mysite.web.servlets;

import org.junit.Test;
import ru.mysite.web.store.CacheUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import  org.mockito.Mockito.*;

/**
 * Created by ainur on 13.11.16.
 */
public class UserCreateServletTest {

    private final CacheUser cache = CacheUser.getInstance();
    @Test
    public void createUser() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("login")).thenReturn("test");// когда получаем  логин вернуть тест
        when(request.getParameter("fio")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("password");
        assertTrue(cache.values().isEmpty()); // проверяем что значально наш кэш пустой
        new UserCreateServlet().doPost(request,response);

        verify(request, atLeast(1)).getParameter("login"); //проверяем что у нас вызван хотя бы один раз метод getParametr
        verify(request, atLeast(1)).getParameter("fio");
        verify(request, atLeast(1)).getParameter("password");
        assertFalse(cache.values().isEmpty()); // наш кэш из пользователей должен быть не пустым

        cache.delete(cache.findByLogin("test").getId()); // удаляем созданного нами пользователя
    }

}