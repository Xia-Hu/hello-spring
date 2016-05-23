package hello;

import java.util.List;

public interface UserMapper {

	public void insertUser(User user);
	
	public User getUser(String name);
	
	public List<User> getAll();
	
}
