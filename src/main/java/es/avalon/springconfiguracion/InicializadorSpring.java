package es.avalon.springconfiguracion;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class InicializadorSpring implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // da de alta el contexto de Spring y lo liga a una aplicacion web
        AnnotationConfigWebApplicationContext contexto= new AnnotationConfigWebApplicationContext();
        contexto.register(ConfiguradorSpring.class);
        contexto.setServletContext(servletContext);
       
        // registro yo dinamicamente un servlet que tiene Spring
        // que se denomina Dispatcher
        // para substituar a los que yo tengo.
        ServletRegistration.Dynamic servlet= servletContext.addServlet("dispatcher", new DispatcherServlet(contexto) );
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
}
