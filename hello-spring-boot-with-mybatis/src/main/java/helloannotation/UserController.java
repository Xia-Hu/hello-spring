package helloannotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/useranno")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/get")
	public User getUserByName(@RequestParam("name") String name) {
		return userService.getUserInfor(name);
	}
	
	@ResponseBody
	@RequestMapping("/getall")
	public List<User> getAll() {
		return userService.getAll();
	}

}
