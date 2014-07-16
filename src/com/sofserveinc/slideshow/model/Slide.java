package com.sofserveinc.slideshow.model;

/**
 * Slide model.
 * 
 * @author Erik P. Yuntantyo
 */
public final class Slide {
    /**
     * Slide title.
     */
    private String title;
    
    /**
     * Slide subtitle.
     */
    private String subtitle;
    
    /**
     * Slide content.
     */
    private Object content;
    
    /**
     * Slide type.
     */
    private String type;
    
    /**
     * Slide format.
     */
    private String format;
    
    /**
     * Module constructor.
     * 
     * @param title    Slide title.
     * @param subtitle Slide subtitle.
     * @param content  Slide content.
     * @param type     Slide type.
     * @param format   Slide data format.
     */
    public Slide(final String title,
                 final String subtitle,
                 final Object content,
                 final String type,
                 final String format) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.type = type;
        this.format = format;
    }
    
    /**
     * Gets slide title.
     * 
     * @return the slide title.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Gets slide subtitle.
     * 
     * @return the slide subtitle.
     */
    public String getSubtitle() {
        return subtitle;
    }
    
    /**
     * Gets slide content.
     * 
     * @return the slide content.
     */
    public Object getContent() {
        return content;
    }
    
    /**
     * Gets slide type.
     * 
     * @return the slide type.
     */
    public String getType() {
        return type;
    }
    
    /**
     * Gets slide format.
     * 
     * @return the slide format.
     */
    public String getFormat() {
        return format;
    }
}
