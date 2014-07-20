package com.qlicks.slideshow.service.rule;

/**
 * The rule of inspect type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class InspectRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        return content.toString();
    }
}
