/**
 * 
 */
package com.qlicks.slideshow.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qlicks.slideshow.FactoryManager;
import com.qlicks.slideshow.contract.Rule;
import com.qlicks.slideshow.contract.SlideGeneration;
import com.qlicks.slideshow.model.Slide;
import com.qlicks.slideshow.model.Slideshow;

/**
 * The service of slide generation.
 * 
 * @author Erik P. Yuntantyo
 */
public final class SlideGenerationService implements SlideGeneration {
    @Override
    public String generate(final Slideshow slideshow) throws IOException {
        String template = new String(Files.readAllBytes(Paths.get("template/default.html")));
        Matcher matcher = Pattern.compile("((?m)^\\s*<section>[\\w\\W]*</section>)").matcher(template);        
        String rest = "";
        
        String generatedContent;
        Rule rule;
        
        if (matcher.find()) {
            for (Slide slide : slideshow.getSlides()) {
                if (rest.length() > 0) {
                    rest +=  "\n";
                }
                
                switch(slide.getType()) {
                    case "dateformat":
                        rule = FactoryManager.getBean("dateFormatRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent(), slide.getFormat());
                        break;
                    case "group-by-key":
                        rule = FactoryManager.getBean("groupByKeyRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent());
                        break;
                    case "inspect":
                        rule = FactoryManager.getBean("inspectRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent());
                        break;
                    case "list":
                        rule = FactoryManager.getBean("unordererListRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent());
                        break;
                    case "messageformat":
                        rule = FactoryManager.getBean("messageFormatRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent(), slide.getFormat());
                        break;
                    case "numberformat":
                        rule = FactoryManager.getBean("numberFormatRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent(), slide.getFormat());
                        break;
                    case "paragraph":
                        rule = FactoryManager.getBean("paragraphRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent());
                        break;
                    case "remove-repeats":
                        rule = FactoryManager.getBean("removeRepeatRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent());
                        break;
                    case "sort":
                        rule = FactoryManager.getBean("sortRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent());
                        break;
                    default:
                        rule = FactoryManager.getBean("rawRule", Rule.class);
                        generatedContent = rule.generate(slide.getContent());
                        break;
                }
                
                rest += matcher.group(1)
                               .replace("<%=title%>", slide.getTitle())
                               .replace("<%=subtitle%>", slide.getSubtitle())
                               .replace("<%=content%>", generatedContent);
            }
            
            return matcher.replaceFirst(rest);
        }
        
        return template;
    }    
}
