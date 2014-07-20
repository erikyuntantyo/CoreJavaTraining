package com.qlicks.slideshow.service.rule;

import java.util.Arrays;

/**
 * The rule of sort type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class SortRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        if (content instanceof Object[]) {
            Arrays.sort((int[])content);
            return Arrays.toString((int[])content);
        }
        
        return null;
    }
}
