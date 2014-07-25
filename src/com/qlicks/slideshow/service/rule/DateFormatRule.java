package com.qlicks.slideshow.service.rule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.LogFactory;
import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of date format type.
 * 
 * @author Erik P. Yuntantyo
 */
public class DateFormatRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        try {
            Date date = content.equals("now") ? new Date()
                                              : new SimpleDateFormat().parse((String)content);
            
            if ((format == null) || format.equals("FULL")) {
                return new SimpleDateFormat().format(date);
            } else {
                return new SimpleDateFormat(format).format(date);
            }
        } catch (ParseException exc) {
            LogFactory.getLog(DateFormatRule.class)
                      .error("Error caught while parsing date.", exc);
        }
        
        return "Unknown date format.";
    }
}
