package ru.parsentev.store;

import ru.parsentev.models.Users;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO: comment
 * @author parsentev
 * @since 29.04.2015
 */
public interface Storage {

	public LinkedList<Users> values();

	public int add(final Users user);

	public void edit(final Users user);

	public void delete(final int id);

	public Users get(final int id);

	public Users findByLogin(final String login) ;

	public int generateId();

	public void close();
}
