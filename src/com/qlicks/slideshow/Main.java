package com.qlicks.slideshow;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The main class of the project.
 * 
 * @author Erik P. Yuntantyo
 */
public abstract class Main {
    /**
     * Main method.
     * 
     * @param args The application arguments.
     */
    public static void main(final String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        
        StringBuilder info =
            new StringBuilder()
                .append("Usages:\n")
                .append("\tCoreJavaTraining2 <context_file> <json_data_files> <output_path>\n\n")
                .append("<context_file>\t\tContext configuration file.\n")
                .append("<json_data_file>\tJson data file.\n")
                .append("\t\t\tJust split using whitespace, if file name contains whitespace, ")
                .append("please wrap file name using double quotes (\").\n")
                .append("<output_path>\t\tGenerated slide html path.");
        
        if ((args == null) || (args.length < 3)) {
            System.out.println(info);            
            return;
        }

        final Object obj = new Object();
        final String destinationPath = args[args.length - 1];
        
        File contextFile = new File(args[0]);
        String[] jsonDataFiles = new String[args.length - 2];
        
        System.arraycopy(args, 1, jsonDataFiles, 0, jsonDataFiles.length);
        
        if (!contextFile.getName().endsWith(".xml") || !contextFile.exists()
            || !new File(destinationPath).isDirectory()) {
            System.out.println(info);
            return;
        }
        
        final ApplicationContext context =
            new ClassPathXmlApplicationContext("file:" + contextFile.getAbsolutePath());
        
        for (final String jsonDataFile : jsonDataFiles) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    context.getBean("generator", SlideshowGenerator.class)
                           .generate(jsonDataFile, destinationPath);
                }
            }).start();
        }
    }
}
