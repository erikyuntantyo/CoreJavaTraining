package com.qlicks.slideshow.service.rule;

/**
 * The rule of group by key type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class GroupByKeyRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        return content.toString();
    }
}
