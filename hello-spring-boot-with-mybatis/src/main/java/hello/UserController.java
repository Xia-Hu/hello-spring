package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// RestController: 标识restful类型的控制器servlet
@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;
	
	// ResponseBody 将controller方法返回的对象转换为指定格式，写入到response对象的body数据区
	// RequestMapping 将请求url映射到整个类，或者指定的处理方法上
	@ResponseBody
	@RequestMapping("/getuser")
	public User getUserInfo(@RequestParam("id") int id) {
		return userService.getUserInfor(id);
	}
	
	@ResponseBody
	@RequestMapping("/getall")
	public User[] getAll() {
		return userService.getAll();
	}

}
