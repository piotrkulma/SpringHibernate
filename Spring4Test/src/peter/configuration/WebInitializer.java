package peter.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(Config.class);

		ctx.setServletContext(servletContext);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
		Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
