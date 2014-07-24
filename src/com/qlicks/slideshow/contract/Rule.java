package com.qlicks.slideshow.contract;

/**
 * Interface of slide rule.
 * 
 * @author Erik P. Yuntantyo
 */
public interface Rule {
    /**
     * Generate content by slide rule.
     * 
     * @param content the slide content.
     * @param format  the slide content format.
     * 
     * @return the generated html slide.
     */
    String generate(final Object content, final String format);
}
