package com.qlicks.slideshow.service.rule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.qlicks.slideshow.contract.Rule;

/**
 * The rule of remove-repeats type.
 * 
 * @author Erik P. Yuntantyo
 */
public class RemoveRepeatRule implements Rule {
    @Override
    public String generate(final Object content, final String format) {
        if (content instanceof Object[]) {
            Set<Object> objSet = new HashSet<Object>(Arrays.asList(content));
            Object[] objects = objSet.toArray(new Object[0]);
            
            return Arrays.toString(objects);
        }
        
        return null;
    }
}
