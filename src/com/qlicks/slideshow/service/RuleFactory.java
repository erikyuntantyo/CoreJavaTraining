package com.qlicks.slideshow.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.qlicks.slideshow.contract.Rule;

/**
 * The slide rule factory.
 *
 * @author Erik P. Yuntantyo
 */
public class RuleFactory {
    /**
     * Rule of date format. 
     */
    @Autowired
    private Rule dateFormatRule;
    
    /**
     * Rule of group by key.
     */
    @Autowired
    private Rule groupByKeyRule;
    
    /**
     * Rule of inspect.
     */
    @Autowired
    private Rule inspectRule;
    
    /**
     * Rule of list.
     */
    @Autowired
    private Rule listRule;
    
    /**
     * Rule of message format.
     */
    @Autowired
    private Rule messageFormatRule;
    
    /**
     * Rule of number format.
     */
    @Autowired
    private Rule numberFormatRule;
    
    /**
     * Rule of paragraph.
     */
    @Autowired
    private Rule paragraphRule;
    
    /**
     * Rule of raw.
     */
    @Autowired
    private Rule rawRule;
    
    /**
     * Rule of remove repeats.
     */
    @Autowired
    private Rule removeRepeatRule;
    
    /**
     * Rule of sort.
     */
    @Autowired
    private Rule sortRule;
    
    /**
     * Generate the specified rule.
     * 
     * @param type    the rule type.
     * @param content the rule content.
     * @param format  the rule format.
     * 
     * @return the generated html by rule.
     */
    public String generate(final String type, final Object content, final String format) {
        switch(type) {
            case "dateformat":
                return dateFormatRule.generate(content, format);
            case "group-by-key":
                return groupByKeyRule.generate(content, format);
            case "inspect":
                return inspectRule.generate(content, format);
            case "list":
                return listRule.generate(content, format);
            case "messageformat":
                return messageFormatRule.generate(content, format);
            case "numberformat":
                return numberFormatRule.generate(content, format);
            case "paragraph":
                return paragraphRule.generate(content, format);
            case "remove-repeats":
                return removeRepeatRule.generate(content, format);
            case "sort":
                return sortRule.generate(content, format);
            default:
                return rawRule.generate(content, format);
        }
    }
}
