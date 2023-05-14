package SocialMediaRestAPI.Leon.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	static {
		users.add(new User(++userCount, "Leon", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Bo", LocalDate.now().minusYears(26)));
		users.add(new User(++userCount, "Harry", LocalDate.now().minusYears(23)));
		users.add(new User(++userCount, "Sofie", LocalDate.now().minusYears(20)));
	}
	
	
	public static List<User> findAllUsers(){
		return users;
	}
	
	public static User saveUser(User u) {
		u.setId(++userCount);
		users.add(u);
		return u;
	}
	
	public static User findUser(int id) {
		return users.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	public void removeUser(int id) {
		users.removeIf(x -> x.getId() == id);
	}

}
