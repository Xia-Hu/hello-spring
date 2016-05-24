package hello;

import hello.User;

public interface UserMapper {

	public User getUserById(int id);
	
	public User[] getAll();
	
}
