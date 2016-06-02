package hello;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *  ʵ��WebApplicationInitializer�ӿڣ��൱����ȡ����web.xml���á�
 *  <br/>web.xml��ע�������ʵ��
 *  <br/>1. ��ȡspring������Ϣ
 *  <br/>2. ����servlet��filter��
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
