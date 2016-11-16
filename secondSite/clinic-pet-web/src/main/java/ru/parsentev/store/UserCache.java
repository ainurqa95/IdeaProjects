package ru.parsentev.store;

import ru.parsentev.models.User;
import ru.parsentev.models.Users;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO: comment
 * @author parsentev
 * @since 18.04.2015
 */
public class UserCache implements Storage {
	private static final UserCache INSTANCE = new UserCache();

	//private final Storage storage = new MemoryStorage();
	private final Storage storage = new JdbcStorage();
	public static UserCache getInstance() {
		return INSTANCE;
	}

	@Override
	public LinkedList<Users> values() {
		return (LinkedList<Users>) this.storage.values();
	}

	@Override
	public int add(final Users user) {
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
