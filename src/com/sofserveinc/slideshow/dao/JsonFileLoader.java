package com.sofserveinc.slideshow.dao;

import com.sofserveinc.slideshow.model.Slideshow;

/**
 * Json file loader.
 * The user of this interface can save generated html slideshow
 * into specified path.
 * 
 * @author Erik P. Yuntantyo
 */
public interface JsonFileLoader {
    /**
     * Load json file.
     * 
     * @param jsonPath Json file path.
     * @return the slideshow model.
     */
    Slideshow load(String jsonPath);
}
