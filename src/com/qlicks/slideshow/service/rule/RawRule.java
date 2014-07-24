package com.qlicks.slideshow.service.rule;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of raw type.
 * 
 * @author Erik P. Yuntantyo
 */
public class RawRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        return content.toString();
    }
}
