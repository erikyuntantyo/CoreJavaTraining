package com.qlicks.slideshow.service.rule;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of unordered list type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class UnorderedList implements Rule {
    @Override
    public String getFormat() {
        return "<ul>\n%s</ul>";
    }

    @Override
    public String generate(final Object content) {
        if (content instanceof Object[]) {
            String li = "<li>%s</li>";
            String rest = "";
            
            for (Object obj : (Object[])content) {
                rest += String.format(li + "\n", obj);
            }
            
            if (!rest.isEmpty()) {
                rest = String.format(getFormat(), rest);
            }
            
            return rest;
        }
        
        return null;
    }
}
