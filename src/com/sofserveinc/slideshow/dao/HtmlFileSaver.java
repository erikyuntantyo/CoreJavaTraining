package com.sofserveinc.slideshow.dao;

import com.sofserveinc.slideshow.model.Slideshow;

/**
 * Html file saver.
 * The user of this interface can load json data file into slideshow model.
 * 
 * @author Erik P. Yuntantyo
 */
public interface HtmlFileSaver {
    /**
     * Load json file.
     * 
     * @param jsonPath Json file path.
     * @return the slideshow model.
     */
    Slideshow load(String jsonPath);
}
