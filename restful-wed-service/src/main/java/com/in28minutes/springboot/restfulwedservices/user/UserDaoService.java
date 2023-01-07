package com.in28minutes.springboot.restfulwedservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static Integer id = 0;

	static {
		users.add(new User(++id, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++id, "Eve", LocalDate.now().minusYears(20)));
		users.add(new User(++id, "Jim", LocalDate.now().minusYears(23)));
	}

	public List<User> findAll() {
		return users;
	}

	public User retriveUserById(int userId) {
		Predicate<? super User> predicate = user -> user.getId().equals(userId);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++id);
		users.add(user);
		return user;
	}

	public User deleteUser(int userId) {
		Predicate<? super User> predicate = user -> user.getId().equals(userId);
		User userById = users.stream().filter(predicate).findFirst().orElse(null);
		users.remove(userById);
		return userById;
	}

}
