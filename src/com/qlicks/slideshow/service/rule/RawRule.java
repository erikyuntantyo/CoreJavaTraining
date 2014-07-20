package com.qlicks.slideshow.service.rule;

/**
 * The rule of raw type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class RawRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        return content.toString();
    }
}
