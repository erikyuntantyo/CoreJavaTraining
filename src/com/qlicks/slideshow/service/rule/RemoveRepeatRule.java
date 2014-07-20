package com.qlicks.slideshow.service.rule;

/**
 * The rule of remove-repeats type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class RemoveRepeatRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        return content.toString();
    }
}
