package com.jrtest.vaka.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
/**
 * @author Iaroslav
 * @since 22.12.2014 22:02
 */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerListener(servletContext);
        registerDispatcherServlet(servletContext);
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
    }

//ContextLoaderListener - сервлет загружающий конфигурационные фалы в контекст приложения спринг, созданный контроллером
//DispatcherServlet. Т.е. это сервлет работающий при старте приложения, который загружает по указаным конфигам из AnnotationConfigWebApplicationContext
//все наши контроллеры-сервисы-дао в контейнер. В нашем случае создает контекст(контейнер) с дао и сервисами по их конфигам.
    private void registerListener(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext = createContext(PersistenceConfig.class, ServiceConfig.class);
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(applicationContext);
        servletContext.addListener(contextLoaderListener);
    }
//DispatcherServlet - "форматирует" ответ контроллера(логическое имя) в ответ для томкэта(сервера) с помощью арбитра представлений
//(InternalResourceViewResolver), который представляет этот ответ для пользователя(браузера) в графическом виде.
    private void registerDispatcherServlet(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext dispatcherContext = createContext(WebConfig.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
//Служит для загрузки конфигов в контекст
    private AnnotationConfigWebApplicationContext createContext(final Class<?>... configClasses) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(configClasses);
        return context;
    }
}