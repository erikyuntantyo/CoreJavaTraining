package com.qlicks.slideshow.service.rule;

/**
 * The rule of number format type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class NumberFormatRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        return content.toString();
    }
}
