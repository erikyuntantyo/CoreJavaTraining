package com.qlicks.slideshow.service.rule;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of paragraph type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class Paragraph implements Rule {
    @Override
    public String getFormat() {
        return "<p>%s</p>";
    }

    @Override
    public String generate(final Object content) {
        return String.format(getFormat(), content);
    }
}
