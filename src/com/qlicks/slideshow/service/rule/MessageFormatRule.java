package com.qlicks.slideshow.service.rule;

import java.text.MessageFormat;

/**
 * The rule of message format type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class MessageFormatRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        if (content instanceof Object[]) {
            return new MessageFormat(format).format(content);
        }
        
        return null;
    }
}
