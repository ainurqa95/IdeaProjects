package ru.mysite.web.interfaces;

import ru.mysite.web.models.Users;

import java.util.Collection;

/**
 * Created by ainur on 07.11.16.
 */

    public interface Storage {

        public Collection<Users> values();

        public int add(final Users user);

        public void edit(final Users user);

        public void delete(final int id);

        public Users get(final int id);

        public Users findByLogin(final String login) ;

        public int generateId();

        public void close();
    }

