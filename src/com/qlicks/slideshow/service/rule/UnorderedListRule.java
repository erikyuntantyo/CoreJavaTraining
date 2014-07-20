package com.qlicks.slideshow.service.rule;

/**
 * The rule of unordered list type.
 * 
 * @author Erik P. Yuntantyo
 */
public final class UnorderedListRule extends RuleBase {
    @Override
    public String generate(final Object content, final String format) {
        if (content instanceof Object[]) {
            String li = "<li>%s</li>";
            String rest = "";
            
            for (Object obj : (Object[])content) {
                rest += String.format(li + "\n", obj);
            }
            
            if (!rest.isEmpty()) {
                rest = String.format("<ul>%s</ul>", rest);
            }
            
            return rest;
        }
        
        return null;
    }
}
