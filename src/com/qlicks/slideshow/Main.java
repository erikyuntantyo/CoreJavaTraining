package com.qlicks.slideshow;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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
        PropertyConfigurator.configure("log4j.properties");

        if ((args == null) || (args.length == 0)) {
            System.out.println("Please type json file name in the argument; "
                               + "if multiple file, "
                               + "separates by whitespace.");            
            return;
        }

        FactoryManager
            .initialize()
            .register(SlideshowGenerator.class)
            /*.register(HtmlFileSaver.class, HtmlFileSaverService.class)
            .register(JsonFileLoader.class, JsonFileLoaderService.class)
            .register(SlideGeneration.class, SlideGenerationService.class)*/
            .refresh();
        
        for (final String arg : args) {
            if (arg.contains(HTML_PATH)) {
                Logger
                    .getLogger(Main.class)
                    .warn("File \"" + arg + "\" should not be taken "
                          + "from destination file.\n"
                          + "The file would not be generated.");
                continue;
            }
            
            FactoryManager.context()
                          .getBean("generator", SlideshowGenerator.class)
                          .generate(arg, HTML_PATH);
        }
    }
}
