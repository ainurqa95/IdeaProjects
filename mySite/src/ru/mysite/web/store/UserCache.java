package ru.mysite.web.store;

import ru.mysite.web.interfaces.Storage;
import ru.mysite.web.models.Users;

import java.util.Collection;

/**
 * Created by ainur on 08.11.16.
 */
public class UserCache implements Storage {
    private static final UserCache INSTANCE = new UserCache();
    private final Storage storage = new MemoryStorage();// здесь мы выбираем какую память хотим использовать
    // можем использовать вместо нее JDVC  storage

    public static UserCache getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<Users> values() {
        return this.INSTANCE.values();
    }

    @Override
    public int add( final Users user) {
        return this.storage.add(user);

    }

    @Override
    public void edit(final Users user) {
        this.storage.edit(user);
    }

    @Override
    public void delete(final int id) {
        this.storage.delete(id);
    }

    @Override
    public Users get(final int id) {
        return this.storage.get(id);
    }

    @Override
    public Users findByLogin(final String login) {
        return this.storage.findByLogin(login);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }
}
