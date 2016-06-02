package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/h")
public class HelloController {

	@RequestMapping("/hello")
	public String hello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		// �������õĹ���ȥѰ��WEB-INF/hello.jsp�ļ�
		return "hello";
	}
	
}
