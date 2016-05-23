package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserInfor(int id) {
		return userMapper.getUserById(id);
	}
	
	public User[] getAll() {
		return userMapper.getAll();
	}

}
