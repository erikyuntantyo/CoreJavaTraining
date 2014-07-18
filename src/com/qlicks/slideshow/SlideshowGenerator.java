package com.qlicks.slideshow;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.qlicks.slideshow.contract.SlideGeneration;
import com.qlicks.slideshow.dao.HtmlFileSaver;
import com.qlicks.slideshow.dao.JsonFileLoader;
import com.qlicks.slideshow.model.Slideshow;
import com.qlicks.slideshow.service.HtmlFileSaverService;
import com.qlicks.slideshow.service.JsonFileLoaderService;
import com.qlicks.slideshow.service.SlideGenerationService;

/**
 * Slideshow generator.
 * The user of this interface can generate html slideshow from json data file.
 * 
 * @author Erik P. Yuntantyo
 */
@Configuration
public class SlideshowGenerator {
    /**
     * Get slide generation.
     * 
     * @return the slide generation.
     */
    @Bean
    @Scope("prototype")
    public SlideGeneration generation() {
        return new SlideGenerationService();
    }
    
    /**
     * Get slideshow generator.
     * 
     * @return the slideshow generator module.
     */
    @Bean
    public SlideshowGenerator generator() {
        return this;
    }
    
    /**
     * Get json file loader.
     * 
     * @return the json file loader.
     */
    @Bean
    @Scope("prototype")
    public JsonFileLoader loader() {
        return new JsonFileLoaderService();
    }
    
    /**
     * Get html file saver.
     * 
     * @return the html file saver.
     */
    @Bean
    @Scope("prototype")
    public HtmlFileSaver saver() {
        return new HtmlFileSaverService();
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
                JsonFileLoader jsonFileLoader =
                    FactoryManager.getBean("loader", JsonFileLoader.class);
                SlideGeneration slideGeneration =
                    FactoryManager.getBean("generation", SlideGeneration.class);
                HtmlFileSaver htmlFileSaver =
                    FactoryManager.getBean("saver", HtmlFileSaver.class);
                
                String jsonFile = new File(jsonPath).getName();
                Slideshow slideshow = jsonFileLoader.load(jsonPath);
                String html = slideGeneration.generate(slideshow);
                String destinationPath =
                    htmlFolder
                        + jsonFile.substring(0, jsonFile.lastIndexOf("."))
                        + ".html";
                
                htmlFileSaver.save(html, destinationPath);
                
                Logger.getLogger(SlideshowGenerator.class)
                      .debug("Succeeded generate " + jsonPath + " to " + destinationPath);
            }
        }).start();
    }
}
