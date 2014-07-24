package com.qlicks.slideshow.service.rule;

import java.text.MessageFormat;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of message format type.
 * 
 * @author Erik P. Yuntantyo
 */
public class MessageFormatRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        if (content instanceof Object[]) {
            return new MessageFormat(format).format(content);
        }
        
        return null;
    }
}
