package com.qlicks.slideshow.contract;

/**
 * Interface of slide rule.
 * 
 * @author Erik P. Yuntantyo
 */
public interface Rule {
    /**
     * Generates content by rule.
     * 
     * @param content the content to generate.
     * 
     * @return the generated content.
     */
    String generate(final Object content);
    
    /**
     * Generates content by rule.
     * 
     * @param content the content to generate.
     * @param format  the content format.
     * 
     * @return the generated content.
     */
    String generate(final Object content, final String format);
}
