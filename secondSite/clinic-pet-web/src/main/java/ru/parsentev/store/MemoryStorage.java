package ru.parsentev.store;

import ru.parsentev.models.User;
import ru.parsentev.models.Users;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO: comment
 * @author parsentev
 * @since 29.04.2015
 */
public class MemoryStorage implements Storage {

	private final AtomicInteger ids = new AtomicInteger();

	private final ConcurrentHashMap<Integer, Users> users = new ConcurrentHashMap<Integer, Users>();


	@Override
	public LinkedList<Users> values() {
		return (LinkedList<Users>) this.users.values();
	}

	@Override
	public int add(final Users user) {
		this.users.put(user.getId(), user);
		return user.getId();
	}

	@Override
	public void edit(final Users user) {
		this.users.replace(user.getId(), user);
	}

	@Override
	public void delete(final int id) {
		this.users.remove(id);
	}

	@Override
	public Users get(final int id) {
		return this.users.get(id);
	}

	@Override
	public Users findByLogin(final String login) {
		for (final Users user : users.values()) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
		throw new IllegalStateException(String.format("Login %s not found", login));
	}

	@Override
	public int generateId() {
		return this.ids.incrementAndGet();
	}

	@Override
	public void close() {
	}
}
