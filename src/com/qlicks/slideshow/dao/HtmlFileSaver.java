package com.qlicks.slideshow.dao;

/**
 * Html file saver.
 * The user of this interface can load json data file into slideshow model.
 * 
 * @author Erik P. Yuntantyo
 */
public interface HtmlFileSaver {
    /**
     * Saves slideshow html.
     * 
     * @param slideshowHtml Slideshow html content.
     * @param htmlPath      Html file path.          
     */
    void save(final String slideshowHtml, final String htmlPath);
}
