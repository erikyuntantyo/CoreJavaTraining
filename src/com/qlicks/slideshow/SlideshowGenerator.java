package com.qlicks.slideshow;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.qlicks.slideshow.contract.SlideGeneration;
import com.qlicks.slideshow.dao.HtmlFileSaver;
import com.qlicks.slideshow.dao.JsonFileLoader;
import com.qlicks.slideshow.model.Slideshow;

/**
 * Slideshow generator.
 * The user of this interface can generate html slideshow from json data file.
 * 
 * @author Erik P. Yuntantyo
 */
public class SlideshowGenerator {
    /**
     * Slide generation.
     */
    @Autowired
    private SlideGeneration generation;

    /**
     * Json file loader.
     */
    @Autowired
    private JsonFileLoader loader;

    /**
     * Html file saver.
     */
    @Autowired
    private HtmlFileSaver saver;

    /**
     * Generate slideshow.
     * 
     * @param jsonPath   the json data file path.
     * @param htmlFolder the html file folder.
     */
    public void generate(final String jsonPath, final String htmlFolder) {
        try {
            String jsonFile = new File(jsonPath).getName();
            String destinationPath = htmlFolder
                                     + jsonFile.substring(0, jsonFile.lastIndexOf("."))
                                     + ".html";            
            Slideshow slideshow = loader.load(jsonPath);
            String html = generation.generate(slideshow);
            
            saver.save(html, destinationPath);
        } catch (IOException exc) {
            LogFactory.getLog(SlideshowGenerator.class)
                      .error("Error while generate file.", exc);
        }
    }
}
