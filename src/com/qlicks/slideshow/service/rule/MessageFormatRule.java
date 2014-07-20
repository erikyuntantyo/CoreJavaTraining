package com.qlicks.slideshow.service.rule;

/**
 * The rule of message format type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class MessageFormatRule extends RuleBase {
    @Override
    public String generate(final Object content) {
        return content.toString();
    }
}
