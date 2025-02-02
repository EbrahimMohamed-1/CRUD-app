//package com.crudApp.config;
///*
//Class<?>[] means that the method returns an array of Class objects,
// where each object can be of any type. This is significant in Spring
//  because you can register various configuration classes
//   that may implement different interfaces or extend different classes,
//    all of which are valid as long as they conform to the expected Spring application context.
//
//     Spring uses Class objects to load and instantiate beans at runtime.
//     When you provide a configuration class (like AppContext.class),
//     Spring can read the metadata about that class and use it to create
//     instances of the beans defined within it.
//
//     Type Safety and Reflection:
//     Returning a Class<?> allows Spring to use reflection to inspect
//     the class and its methods, enabling features like dependency injection,
//     bean creation, and context initialization without requiring direct instances.
//
//    Avoiding Object Creation:
//    By returning Class objects rather than instances,
//    you avoid unnecessary instantiation at the time of configuration.
//     Spring will create instances of the necessary beans when it initializes the application context.
//
//
// */
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class AppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//        appContext.register(WebMvcConfig.class);
//        appContext.register(AppContext.class);
//
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
//                "SpringDispatcher", new DispatcherServlet(appContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//
//    }
//}