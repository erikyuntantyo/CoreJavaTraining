package com.qlicks.slideshow;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Slideshow generator.
 * The user of this interface can generate html slideshow from json data file.
 * 
 * @author Erik P. Yuntantyo
 */
@Configuration
public class SlideshowGenerator {
    /**
     * Generator.
     * 
     * @return The slideshow generator module.
     */
    @Bean
    public SlideshowGenerator generator() {
        return this;
    }
    
    /**
     * Generate slideshow.
     * 
     * @param jsonPath   Json data file path.
     * @param htmlFolder Html file folder.
     */
    public final void generate(final String jsonPath, final String htmlFolder) {
        new Thread(new Runnable() {            
            @Override
            public void run() {
                /*JsonFileLoader jsonFileLoader = new JsonFileLoaderService();
                SlideGeneration slideGeneration = new SlideGenerationService();
                HtmlFileSaver htmlFileSaver = new HtmlFileSaverService();
                
                String jsonFile = new File(jsonPath).getName();
                Slideshow slideshow = jsonFileLoader.load(jsonPath);
                String html = slideGeneration.generate(slideshow);
                String destinationPath = new File(htmlFolder
                                                  + jsonFile.substring(0, jsonFile.lastIndexOf(".")))
                                             .getAbsolutePath() + ".html";
                
                htmlFileSaver.save(html, destinationPath);*/
                
                Logger.getLogger(SlideshowGenerator.class).debug("Succeeded generate " + jsonPath);
            }
        }).start();
    }
}
