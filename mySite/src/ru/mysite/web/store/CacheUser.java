package ru.mysite.web.store;

import ru.mysite.web.interfaces.Storage;
import ru.mysite.web.models.Users;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ainur on 09.11.16.
 */
public class CacheUser implements Storage {
    private static final CacheUser INSTANCE = new CacheUser();

    private final ConcurrentHashMap<Integer, Users> users = new ConcurrentHashMap<Integer, Users>();

    public static CacheUser getInstance() {
        return INSTANCE;
    }
    @Override
    public Collection<Users> values() {
        return this.users.values();
    }

    @Override
    public int add(Users user) { // добавляем в коллекцию и получаем id
        this.users.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public void edit(Users user) {
        this.users.replace(user.getId(), user);
    }

    @Override
    public void delete(int id) {
        this.users.remove(id);
    }

    @Override
    public Users get(int id) { // получаем объект
        return this.users.get(id);
    }

    @Override
    public Users findByLogin(String login) {
        for (final Users user : users.values()) {
            if (user.getLogin().equals(login)) {
                return user;
            }

        }
        throw new IllegalStateException(String.format("Login %s not found", login));
    }
    @Override
    public int generateId() {
        return 1; //this.ids.incrementAndGet();

    }

    @Override
    public void close() {

    }
}
