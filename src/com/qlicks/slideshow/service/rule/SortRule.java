package com.qlicks.slideshow.service.rule;

import java.util.Arrays;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of sort type.
 * 
 * @author Erik P. Yuntantyo
 */
public class SortRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        if (content instanceof Object[]) {
            Arrays.sort((int[])content);
            return Arrays.toString((int[])content);
        }
        
        return null;
    }
}
