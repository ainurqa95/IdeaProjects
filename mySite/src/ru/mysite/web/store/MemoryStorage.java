package ru.mysite.web.store;

import ru.mysite.web.interfaces.Storage;
import ru.mysite.web.models.Users;

import java.util.Collection;

/**
 * Created by ainur on 08.11.16.
 */
public class MemoryStorage implements Storage {

    @Override
    public Collection<Users> values() {
        return null;
    }

    @Override
    public int add(Users user) {
        return 0;
    }

    @Override
    public void edit(Users user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Users get(int id) {
        return null;
    }

    @Override
    public Users findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }
}
