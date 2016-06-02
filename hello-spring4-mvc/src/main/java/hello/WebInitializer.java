package hello;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *  实现WebApplicationInitializer接口，相当于是取代了web.xml配置。
 *  <br/>web.xml的注解替代的实现
 *  <br/>1. 获取spring配置信息
 *  <br/>2. 配置servlet和filter等
 * @author huxia205906
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(Config.class);
		context.setServletContext(servletContext);
		
		Dynamic dynamicServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		dynamicServlet.addMapping("/");
		dynamicServlet.setLoadOnStartup(1);

	}

}
