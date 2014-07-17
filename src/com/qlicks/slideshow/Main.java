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
        if ((args == null) || (args.length == 0)) {
            System.out.println("Please type json file name in the argument; "
                               + "if multiple file, "
                               + "separates with whitespace.");            
            return;
        }
        
        for (String arg : args) {
            if (arg.contains(OUTPUT_FILE)) {
                Logger
                    .getLogger(Main.class)
                    .warn("File \"" + arg + "\" should not be taken "
                          + "from destination file.\n"
                          + "The file would not be generated.");
                continue;
            }
            
            // TODO Load generator here.            
        }
    }
}
