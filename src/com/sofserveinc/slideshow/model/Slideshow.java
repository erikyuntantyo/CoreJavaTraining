package com.sofserveinc.slideshow.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Slideshow model which contains list of slide model.
 * 
 * @author Erik P. Yuntantyo
 */
public final class Slideshow {
    /**
     * List of slide models.
     */
    private List<Slide> slides;
    
    /**
     * Module constructor.
     * 
     * @param slides Array of slide models.
     */
    public Slideshow(final Slide... slides) {
        if ((slides != null) && (slides.length > 0)) {
            this.slides = Arrays.asList(slides);
        } else {
            this.slides = new ArrayList<>();
        }
    }

    /**
     * Gets list of slide.
     * 
     * @return the list of slide.
     */
    public List<Slide> getSlides() {
        return slides;
    }    
}
