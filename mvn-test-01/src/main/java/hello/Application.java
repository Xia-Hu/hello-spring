package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 *   Configuration 表示这个类可以作为bean来源
 * @author huxia205906
 *
 */
@Configuration
@ComponentScan
public class Application {

	/**
	 *  Just like a bean property in xml:
	 *  <bean id="mockMessageService" class="hello.MessageService" />
	 * @return
	 */
	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "Hello World! ";
			}
		};
	}
	
	
//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//		MessagePrinter printer = context.getBean(MessagePrinter.class);
//		printer.printMessage();
//	}
//	
}
