package com.sofserveinc.slideshow.dao;

/**
 * Json file loader.
 * The user of this interface can save generated html slideshow
 * into specified path.
 * 
 * @author Erik P. Yuntantyo
 */
public interface JsonFileLoader {
    /**
     * Saves slideshow html.
     * 
     * @param slideshowHtml Slideshow html content.
     * @param htmlPath      Html file path.          
     */
    void save(final String slideshowHtml, final String htmlPath);
}
