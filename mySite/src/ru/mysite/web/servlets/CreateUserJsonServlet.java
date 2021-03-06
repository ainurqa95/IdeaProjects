package ru.mysite.web.servlets;

import ru.mysite.web.models.Users;
import ru.mysite.web.store.CacheUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ainur on 13.11.16.
 */
public class CreateUserJsonServlet extends HttpServlet {
    private final CacheUser USER_CACHE = CacheUser.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String hashedPass = getHashedPass(req.getParameter("password"));

        this.USER_CACHE.add(new Users(this.USER_CACHE.generateId(),req.getParameter("fio"), req.getParameter("login"), hashedPass));
        req.setAttribute("users", this.USER_CACHE.values());
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }


    private String getHashedPass(String pass) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.reset();
        md5.update(pass.getBytes()); // вычисляем hash от cообщения и id
        byte[] digest = md5.digest();
        BigInteger h = new BigInteger(1,digest);
        return h.toString();
    }
}
