package com.qlicks.slideshow.service.rule;

import com.qlicks.slideshow.contract.Rule;

/**
 * The slide rule base.
 * 
 * @author Erik P. Yuntantyo
 */
public abstract class RuleBase implements Rule {
    @Override
    public String generate(final Object content) {
        return generate(content, null);
    }
    
    @Override
    public String generate(final Object content, final String format) {
        return null;
    }
}
