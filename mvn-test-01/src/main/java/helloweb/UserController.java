package helloweb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/{id}")
	public User view(@PathVariable("id") long id) {
		User user = new User();
		user.setId(id);
		user.setName("Xia");
		
		return user;
	}
}
