package com.qlicks.slideshow.service.rule;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of raw type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class Raw implements Rule {
    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public String generate(final Object content) {
        return content.toString();
    }
}
