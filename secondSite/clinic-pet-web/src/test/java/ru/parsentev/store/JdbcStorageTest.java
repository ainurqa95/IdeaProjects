package ru.parsentev.store;

import org.junit.Test;
import ru.parsentev.garbage.Users;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * TODO: comment
 * @author parsentev
 * @since 29.04.2015
 */
public class JdbcStorageTest {

	@Test
	public void ADDTest(){
		JdbcStorage storage = new JdbcStorage();
		int id = storage.add(new Users("arny","marny","asgasgd", 2));
		Users user = storage.get(id);
		assertEquals(user.getId(),id);
		storage.close();
	}

	@Test
	public void UpdateTest(){
		JdbcStorage storage = new JdbcStorage();
		int id = 10;
		Users user = new Users(id,"Ain","ainurqa95", "a4hfgebi",1);
		storage.edit(user);
		Users updatedUser = storage.get(id);

		assertEquals (updatedUser.getFio(),"Ain");

		storage.close();
	}
	@Test
	public void DeleteTest(){
		JdbcStorage storage = new JdbcStorage();
		int id = 11;
		storage.delete(id);

		storage.close();
	}
	@Test
	public void findLogin(){
		JdbcStorage storage = new JdbcStorage();
		String login = "marny";
		Users user = storage.findByLogin(login);
		assertEquals (user.getFio(),"arny");
		storage.close();
	}
	@Test
	public void collection(){
		JdbcStorage storage = new JdbcStorage();
		Collection<Users> users = storage.values();
		for (Users user: users
				) {
			System.out.println("fio = " + user.getFio());
		}
		storage.close();
	}
}