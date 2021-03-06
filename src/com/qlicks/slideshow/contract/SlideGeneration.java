package com.qlicks.slideshow.contract;

import java.io.IOException;

import com.qlicks.slideshow.model.Slideshow;

/**
 * Slideshow generation.
 * The user of this interface can generate html slideshow from slideshow model
 * that generated from json files.
 * 
 * @author Erik P. Yuntantyo
 */
public interface SlideGeneration {
    /**
     * Generate slideshow content (html).
     * 
     * @param slideshow Slideshow model.
     * 
     * @return the generated html string.
     * 
     * @throws IOException 
     */
    String generate(final Slideshow slideshow) throws IOException;
}
