package com.qlicks.slideshow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Factory manager.
 * 
 * @author Erik P. Yuntantyo
 */
public final class FactoryManager {
    /**
     * Instance of factory manager. 
     */
    private static FactoryManager instance;
    
    /**
     * Application context.
     */
    private ApplicationContext context;
    
    /**
     * Factory manager constructor.
     */
    private FactoryManager() {
        context = new AnnotationConfigApplicationContext();
    }
    
    /**
     * Factory manager constructor.
     * 
     * @param annotatedClasses Annotated classes that would be
     *                         registered to application context.
     */
    private FactoryManager(final Class<?>... annotatedClasses) {
        context = new AnnotationConfigApplicationContext(annotatedClasses);
    }

    /**
     * Close factory manager.
     */
    public static void close() {
        ((AnnotationConfigApplicationContext)instance.context).close();
    }
    
    /**
     * Get application context bean.
     * 
     * @param <T>  Dynamic type.
     * 
     * @param arg0 The bean name.
     * @param arg1 The bean object.
     * 
     * @return the instance of bean.
     */
    public static <T> T getBean(final String arg0, final Class<T> arg1) {
        return instance.context.getBean(arg0, arg1);
    }
    
    /**
     * Initialize factory manager.
     * 
     * @return the factory manager.
     */
    public static FactoryManager initialize() {
        instance = new FactoryManager();
        return instance;
    }
    
    /**
     * Initialize factory manager.
     * 
     * @param annotatedClasses Annotated classes that would be
     *                         registered to application context.
     */
    public static void initialize(final Class<?>... annotatedClasses) {
        instance = new FactoryManager(annotatedClasses);
    }
    
    /**
     * Register object.
     * 
     * @param annotatedClasses Annotated classes that would be
     *                         registered to application context.
     *                         
     * @return the factory manager.
     */
    public FactoryManager register(final Class<?>... annotatedClasses) {
        ((AnnotationConfigApplicationContext)context).register(annotatedClasses);
        
        return this;
    }
    
    /**
     * Refresh registered annotated classes.
     */
    public void refresh() {
        ((AnnotationConfigApplicationContext)context).refresh();
    }
}
