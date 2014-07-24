package com.qlicks.slideshow.service.rule;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of group by key type.
 * 
 * @author Erik P. Yuntantyo
 */
public class GroupByKeyRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        return content.toString();
    }
}
