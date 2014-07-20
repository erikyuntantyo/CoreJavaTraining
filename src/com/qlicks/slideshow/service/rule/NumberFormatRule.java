package com.qlicks.slideshow.service.rule;

import java.text.NumberFormat;

/**
 * The rule of number format type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class NumberFormatRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        return NumberFormat.getInstance().format(content);
    }
}
