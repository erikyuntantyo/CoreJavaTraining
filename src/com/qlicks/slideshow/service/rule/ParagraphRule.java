package com.qlicks.slideshow.service.rule;

/**
 * The rule of paragraph type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class ParagraphRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        return String.format("<p>%s</p>", content);
    }
}
