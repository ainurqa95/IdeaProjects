package ru.parsentev.store;


import ru.parsentev.models.Users;
import ru.parsentev.service.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 * @author parsentev
 * @since 29.04.2015
 */
public class JdbcStorage implements Storage {
	private final Connection connection;

	public JdbcStorage() {
		final Settings settings = Settings.getInstance();
		try {
			this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public List<Users> values() {
		final List<Users> users = new ArrayList<>();
		try (final Statement statement = this.connection.createStatement();
		     final ResultSet rs = statement.executeQuery("select * from users")) {
			while (rs.next()) {

				users.add(new Users(rs.getInt("id"), rs.getString("fio"), rs.getString("login"), rs.getString("password"), rs.getInt("city")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int add(Users user) {
		// испоьзуем подготовленный запрос
		try (final PreparedStatement statement = this.connection.prepareStatement("insert into users ( fio, login, password, city) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
			// Statement.RETURN_GENERATED_KEYS для автоинкрмента
			statement.setString(1, user.getFio());
			statement.setString(2, user.getLogin());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getCityId());
			statement.executeUpdate(); // выполняем запрос
			// statement.getGeneratedKeys() возвращает id добавленного
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException("Could not create new user");
	}

	@Override
	public void edit(Users user) {
		// испоьзуем подготовленный запрос
		try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE users set  fio= (?) , login = (?), password =(?), city=(?) where id= (?)", Statement.RETURN_GENERATED_KEYS)) {
			// Statement.RETURN_GENERATED_KEYS для автоинкрмента
			statement.setString(1, user.getFio());
			statement.setString(2, user.getLogin());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getCityId());
			statement.setInt(5, user.getId());
			statement.executeUpdate(); // выполняем запрос

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



	@Override
	public void delete(int id) {
		try (final PreparedStatement statement = this.connection.prepareStatement("delete from users where id=(?)")) {
			statement.setInt(1, id);
			statement.executeUpdate(); // выполняем запрос
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Users get(int id) {
		try (final PreparedStatement statement = this.connection.prepareStatement("select * from users where id=(?)")) {
			statement.setInt(1, id);
			try (final ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					return new Users(rs.getInt("id"), rs.getString("fio"), rs.getString("login"), rs.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException(String.format("User %s does not exists", id));
	}

	@Override
	public Users findByLogin(String login){

		try (final PreparedStatement statement = this.connection.prepareStatement("select * from users where login=(?)")) {
			statement.setString(1, login);
			try (final ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					return new Users(rs.getInt("id"), rs.getString("fio"), rs.getString("login"), rs.getString("password"), rs.getInt("city"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException(String.format("User %s does not exists", login));
	}

	@Override
	public int generateId() {
		return 0;
	}

	@Override
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
