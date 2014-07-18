package com.sofserveinc.slideshow;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sofserveinc.slideshow.contract.SlideGeneration;
import com.sofserveinc.slideshow.dao.HtmlFileSaver;
import com.sofserveinc.slideshow.dao.JsonFileLoader;
import com.sofserveinc.slideshow.model.Slideshow;
import com.sofserveinc.slideshow.service.HtmlFileSaverService;
import com.sofserveinc.slideshow.service.JsonFileLoaderService;
import com.sofserveinc.slideshow.service.SlideGenerationService;

/**
 * Slideshow generator.
 * The user of this interface can generate html slideshow from json data file.
 * 
 * @author Erik P. Yuntantyo
 */
@Configuration
public final class SlideshowGenerator {
    /**
     * Generate slideshow.
     * 
     * @param jsonPath   Json data file path.
     * @param htmlFolder Html file folder.
     */
    @Bean
    public void generate(final String jsonPath, final String htmlFolder) {
        JsonFileLoader jsonFileLoader = new JsonFileLoaderService();
        SlideGeneration slideGeneration = new SlideGenerationService();
        HtmlFileSaver htmlFileSaver = new HtmlFileSaverService();
        
        String jsonFile = new File(jsonPath).getName();
        Slideshow slideshow = jsonFileLoader.load(jsonPath);
        String html = slideGeneration.generate(slideshow);
        String destinationPath = new File(htmlFolder
                                          + jsonFile.substring(0, jsonFile.lastIndexOf(".")))
                                     .getAbsolutePath() + ".html";
        
        htmlFileSaver.save(html, destinationPath);
    }
}
