package hello;

import java.util.List;

public interface UserMapper {

	public User getUserById(int id);
	
	public User[] getAll();
	
}
