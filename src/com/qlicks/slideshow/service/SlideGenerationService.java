package com.qlicks.slideshow.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

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
    /**
     * Slide rule.
     */
    @Autowired
    private RuleFactory ruleFactory;
    
    @Override
    public String generate(final Slideshow slideshow) throws IOException {
        String template = new String(Files.readAllBytes(Paths.get("template/default.html")));
        Matcher matcher = Pattern.compile("((?m)^\\s*<section>[\\w\\W]*</section>)").matcher(template);        
        String rest = "";
        
        String generatedContent;
        
        if (matcher.find()) {
            for (Slide slide : slideshow.getSlides()) {
                if (rest.length() > 0) {
                    rest +=  "\n";
                }
                
                generatedContent = ruleFactory.generate(slide.getType(),
                                                        slide.getContent(),
                                                        slide.getFormat());
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
