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
     * @param annotatedClasses The annotated classes that would be
     *                         registered to application context.
     */
    private FactoryManager(final Class<?>... annotatedClasses) {
        context = new AnnotationConfigApplicationContext(annotatedClasses);
    }
    
    /**
     * Initialize factory manager.
     * 
     * @return The factory manager.
     */
    public static FactoryManager initialize() {
        instance = new FactoryManager();
        return instance;
    }
    
    /**
     * Initialize factory manager.
     * 
     * @param annotatedClasses The annotated classes that would be
     *                         registered to application context.
     */
    public static void initialize(final Class<?>... annotatedClasses) {
        instance = new FactoryManager(annotatedClasses);
    }
    
    /**
     * Application context.
     * 
     * @return The application context.
     */
    public static ApplicationContext context() {
        return instance.context;
    }
    
    /**
     * Register object.
     * 
     * @param annotatedClasses The annotated classes that would be
     *                         registered to application context.
     *                         
     * @return The factory manager.
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
