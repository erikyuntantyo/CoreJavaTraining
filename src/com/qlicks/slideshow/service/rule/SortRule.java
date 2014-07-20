package com.qlicks.slideshow.service.rule;

/**
 * The rule of sort type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class SortRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        return content.toString();
    }
}
