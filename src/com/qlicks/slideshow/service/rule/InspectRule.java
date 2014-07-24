package com.qlicks.slideshow.service.rule;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of inspect type.
 * 
 * @author Erik P. Yuntantyo
 */
public class InspectRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        StringBuilder builder = new StringBuilder();
        
        builder.append("<p>")
               .append(content.getClass().getName())
               .append("</p>\n")
               .append("<div>Fields:</div>\n")
               .append("<ul>\n");
        
        for (Field field : content.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            
            builder.append("<li>")
                   .append(field.getName())
                   .append("</li>\n");
        }
        
        builder.append("</ul>\n")
               .append("<div>Methods:</div>\n")
               .append("<ul>\n");
        
        for (Method method : content.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            
            builder.append("<li>")
                   .append(method.getName())
                   .append("</li>\n");
        }
        
        builder.append("</ul>\n");
        
        return builder.toString();
    }
}
