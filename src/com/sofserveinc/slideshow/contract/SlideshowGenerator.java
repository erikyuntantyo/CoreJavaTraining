package com.sofserveinc.slideshow.contract;

/**
 * Slideshow generator.
 * The user of this interface can generate html slideshow from json data file.
 * 
 * @author Erik P. Yuntantyo
 */
public interface SlideshowGenerator {
    /**
     * Generate slideshow.
     * 
     * @param jsonPath   Json data file path.
     * @param htmlFolder Html file folder.
     */
    void generate(final String jsonPath, final String htmlFolder);
}
