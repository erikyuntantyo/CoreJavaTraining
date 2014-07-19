package com.qlicks.slideshow.contract;

/**
 * Interface of slide rule.
 * 
 * @author Erik P. Yuntantyo
 */
public interface Rule {
    /**
     * Gets content format.
     * 
     * @return the content format.
     */
    String getFormat();
    
    /**
     * Generates content by rule.
     * 
     * @param content the content to generate.
     * @return the generated content.
     */
    String generate(final Object content);
}
