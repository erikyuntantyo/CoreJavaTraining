package com.qlicks.slideshow.service.rule;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of paragraph type.
 * 
 * @author Erik P. Yuntantyo
 */
public class ParagraphRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        return String.format("<p>%s</p>", content);
    }
}
