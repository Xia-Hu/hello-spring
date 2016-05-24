package helloannotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private IUserDao userDao;
	
	public User getUserInfor(String name) {
		return userDao.getUserByName(name);
	}
	
	public List<User> getAll() {
		return userDao.getAll();
	}
	
}
