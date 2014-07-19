/**
 * 
 */
package com.qlicks.slideshow.service;

import org.apache.log4j.Logger;

import com.qlicks.slideshow.contract.SlideGeneration;
import com.qlicks.slideshow.model.Slide;
import com.qlicks.slideshow.model.Slideshow;

/**
 * The service of slide generation.
 * 
 * @author Erik P. Yuntantyo
 */
public final class SlideGenerationService implements SlideGeneration {
    @Override
    public String generate(final Slideshow slideshow) {
        for (Slide slide : slideshow.getSlides()) {
            Logger.getLogger(SlideGeneration.class)
                  .debug("Slide.title = " + slide.getTitle());
        }
        
        return null;
    }    
}
