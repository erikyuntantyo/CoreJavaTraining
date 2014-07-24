package com.qlicks.slideshow.service.rule;

import java.text.NumberFormat;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of number format type.
 * 
 * @author Erik P. Yuntantyo
 */
public class NumberFormatRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        return NumberFormat.getInstance().format(content);
    }
}
