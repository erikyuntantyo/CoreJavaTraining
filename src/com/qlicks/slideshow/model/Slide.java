package com.qlicks.slideshow.model;

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
     * Slide content type.
     */
    private String type;
    
    /**
     * Slide content format.
     */
    private String format;
    
    /**
     * Slide constructor.
     */
    public Slide() {
        
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
     * Sets slide title.
     * 
     * @param title the slide title to set.
     */
    public void setTitle(final String title) {
        this.title = title;
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
     * Sets slide subtitle.
     * 
     * @param subtitle the slide subtitle to set.
     */
    public void setSubtitle(final String subtitle) {
        this.subtitle = subtitle;
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
     * Sets slide content.
     * 
     * @param content the slide content to set.
     */
    public void setContent(final Object content) {
        this.content = content;
    }

    /**
     * Gets slide content type.
     * 
     * @return the slide type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets slide content type.
     * 
     * @param type the slide type to set.
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Gets slide content format.
     * 
     * @return the slide content format.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets slide content format.
     * 
     * @param format the slide content format to set.
     */
    public void setFormat(final String format) {
        this.format = format;
    }
}
