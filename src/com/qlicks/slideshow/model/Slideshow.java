package com.qlicks.slideshow.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.util.JSONUtils;

/**
 * Slideshow model which contains list of slide model.
 * 
 * @author Erik P. Yuntantyo
 */
public final class Slideshow {
    /**
     * List of slides.
     */
    private List<?> slides;
    
    /**
     * Slideshow constructor. 
     */
    public Slideshow() {
        
    }
    
    /**
     * Gets list of slide.
     * 
     * @return the list of slide.
     */
    public List<Slide> getSlides() {
        List<Slide> rest = new ArrayList<>();
        MorpherRegistry registry = JSONUtils.getMorpherRegistry();
        Morpher dynaMorpher = new BeanMorpher(getClass(), registry);
        
        registry.registerMorpher(dynaMorpher);
        
        for (Iterator<?> i = slides.iterator(); i.hasNext();) {
            rest.add((Slide)registry.morph(Slide.class, i.next()));
        }
        
        return rest;
    }

    /**
     * Sets slide list.
     * 
     * @param slides the slides to set.
     */
    public void setSlides(final List<?> slides) {
        this.slides = slides;
    }
}
