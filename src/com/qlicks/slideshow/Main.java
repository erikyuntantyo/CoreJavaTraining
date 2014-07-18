package com.qlicks.slideshow;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sofserveinc.slideshow.SlideshowGenerator;

/**
 * The main class of the project.
 * 
 * @author Erik P. Yuntantyo
 */
public abstract class Main {
    /**
     * Destination context configuration file.
     */
    private static final String HTML_PATH = "../slideshow/generated/";
    
    /**
     * Main method.
     * 
     * @param args Application arguments.
     */
    public static void main(final String[] args) {
        Thread worker;
        
        PropertyConfigurator.configure("log4j.properties");
        
        if ((args == null) || (args.length == 0)) {
            System.out.println("Please type json file name in the argument; "
                               + "if multiple file, "
                               + "separates by whitespace.");            
            return;
        }
        
        for (final String arg : args) {
            if (arg.contains(HTML_PATH)) {
                Logger
                    .getLogger(Main.class)
                    .warn("File \"" + arg + "\" should not be taken "
                          + "from destination file.\n"
                          + "The file would not be generated.");
                continue;
            }
            
            worker = new Thread(new Runnable() {
                private AnnotationConfigApplicationContext context;
                
                @Override
                public void run() {
                    Logger.getLogger(Main.class).debug("Begin generates slideshow...");
                    
                    context = new AnnotationConfigApplicationContext(SlideshowGenerator.class);
                    context.getBean("generate", arg, HTML_PATH);
                }
            });
            worker.setDaemon(true);
            worker.start();
        }
    }
}
