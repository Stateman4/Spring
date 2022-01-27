package ru.gb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebConfig implements WebApplicationInitializer {

    public static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    //вызывается автоматически при запуске приложения(при запуске ТомСат)
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
     log.info("in onSturtUp");

     //вместо void main теперь контекст создается здесь
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(HelloConfiguration.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);


        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        //установка порядка загрузки
        registration.setLoadOnStartup(1); //загрузится первым
        registration.addMapping("/"); // корневой URL
    }
}
