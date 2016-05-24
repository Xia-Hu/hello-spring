package helloannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  helloannotation包中是用注解方式整合mybatis和spring的例子
 *  hello包中是用xml方式整合mybatis和spring的例子
 * @author huxia205906
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
