package com.qlicks.slideshow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
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
     * Spring application context.
     */
    private static ApplicationContext context;
    
    /**
     * Json data file names.
     */
    private static String[] jsonDataFiles;
    
    /**
     * Output path of html slideshow.
     */
    private static String outputPath;
    
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
        
        File contextFile = new File(args[0]);
        
        jsonDataFiles = new String[args.length - 2];        
        outputPath = args[args.length - 1];
        
        System.arraycopy(args, 1, jsonDataFiles, 0, jsonDataFiles.length);
        
        if (!contextFile.getName().endsWith(".xml") || !contextFile.exists()
            || !new File(outputPath).isDirectory()) {
            System.out.println(info);
            return;
        }
        
        context = new ClassPathXmlApplicationContext("file:" + contextFile.getAbsolutePath());
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Thread> workers = new ArrayList<>();
                    
                    for (final String jsonDataFile : jsonDataFiles) {
                        Thread worker = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                context.getBean("generator", SlideshowGenerator.class)
                                       .generate(jsonDataFile, outputPath);
                                LogFactory.getLog(Main.class).info(Thread.currentThread().getName() + " exits...");
                            }
                        });
                        worker.setDaemon(true);
                        worker.setName(jsonDataFile + "-worker");
                        worker.start();
                        
                        LogFactory.getLog(Main.class).info(worker.getName() + " starts...");
                        
                        workers.add(worker);
                    }
                    
                    for (Thread worker : workers) {
                        worker.join();
                    }
                } catch (InterruptedException exc) {
                    LogFactory.getLog(Main.class)
                              .error("Error while thread working.", exc);
                }
            }
        }).start();
    }
}
