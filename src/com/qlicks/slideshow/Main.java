package com.qlicks.slideshow;

import org.apache.log4j.Logger;

/**
 * The main class of the project.
 * 
 * @author Erik P. Yuntantyo
 */
public abstract class Main {
    /**
     * Destination context configuration file.
     */
    private static final String OUTPUT_FILE =
        "C:/nginx/html/html-slideshow/example/";
    
    /**
     * Main method.
     * 
     * @param args Application arguments.
     */
    public static void main(final String[] args) {
        if (!args[0].contains(OUTPUT_FILE)) {
            String sourceConfig = args[0];
            
            Logger.getLogger(Main.class).debug(sourceConfig);
        } else {
            Logger
                .getLogger(Main.class)
                .warn("Configuration file should not be taken "
                      + "from destination file.");
        }
    }
}
