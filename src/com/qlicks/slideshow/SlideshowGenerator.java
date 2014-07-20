package com.qlicks.slideshow;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.qlicks.slideshow.contract.Rule;
import com.qlicks.slideshow.contract.SlideGeneration;
import com.qlicks.slideshow.dao.HtmlFileSaver;
import com.qlicks.slideshow.dao.JsonFileLoader;
import com.qlicks.slideshow.model.Slideshow;
import com.qlicks.slideshow.service.HtmlFileSaverService;
import com.qlicks.slideshow.service.JsonFileLoaderService;
import com.qlicks.slideshow.service.SlideGenerationService;
import com.qlicks.slideshow.service.rule.DateFormatRule;
import com.qlicks.slideshow.service.rule.GroupByKeyRule;
import com.qlicks.slideshow.service.rule.InspectRule;
import com.qlicks.slideshow.service.rule.MessageFormatRule;
import com.qlicks.slideshow.service.rule.NumberFormatRule;
import com.qlicks.slideshow.service.rule.ParagraphRule;
import com.qlicks.slideshow.service.rule.RawRule;
import com.qlicks.slideshow.service.rule.RemoveRepeatRule;
import com.qlicks.slideshow.service.rule.SortRule;
import com.qlicks.slideshow.service.rule.UnorderedListRule;

/**
 * Slideshow generator.
 * The user of this interface can generate html slideshow from json data file.
 * 
 * @author Erik P. Yuntantyo
 */
@Configuration
public class SlideshowGenerator {
    /**
     * Gets slide generation.
     * 
     * @return the slide generation.
     */
    @Bean
    @Scope("prototype")
    public SlideGeneration generation() {
        return new SlideGenerationService();
    }
    
    /**
     * Gets slideshow generator.
     * 
     * @return the slideshow generator module.
     */
    @Bean
    public SlideshowGenerator generator() {
        return this;
    }
    
    /**
     * Gets json file loader.
     * 
     * @return the json file loader.
     */
    @Bean
    @Scope("prototype")
    public JsonFileLoader loader() {
        return new JsonFileLoaderService();
    }
    
    /**
     * Gets html file saver.
     * 
     * @return the html file saver.
     */
    @Bean
    @Scope("prototype")
    public HtmlFileSaver saver() {
        return new HtmlFileSaverService();
    }
    
    /**
     * Get date format rule.
     * 
     * @return the date format rule.
     */
    @Bean
    @Scope("prototype")
    public Rule dateFormatRule() {
        return new DateFormatRule();
    }
    
    /**
     * Gets group by key rule.
     * 
     * @return the group by key rule.
     */
    @Bean
    @Scope("prototype")
    public Rule groupByKeyRule() {
        return new GroupByKeyRule();
    }

    /**
     * Gets inspect rule.
     * 
     * @return the inspect rule.
     */
    @Bean
    @Scope("prototype")
    public Rule inspectRule() {
        return new InspectRule();
    }

    /**
     * Gets message format rule.
     * 
     * @return the message format rule.
     */
    @Bean
    @Scope("prototype")
    public Rule messageFormatRule() {
        return new MessageFormatRule();
    }

    /**
     * Gets number format rule.
     * 
     * @return the number format rule.
     */
    @Bean
    @Scope("prototype")
    public Rule numberFormatRule() {
        return new NumberFormatRule();
    }

    /**
     * Gets paragraph rule.
     * 
     * @return the paragraph rule.
     */
    @Bean
    @Scope("prototype")
    public Rule paragraphRule() {
        return new ParagraphRule();
    }

    /**
     * Gets raw rule.
     * 
     * @return the raw rule.
     */
    @Bean
    @Scope("prototype")
    public Rule rawRule() {
        return new RawRule();
    }

    /**
     * Gets remove-repeat rule.
     * 
     * @return the remove-repeat rule.
     */
    @Bean
    @Scope("prototype")
    public Rule removeRepeatRule() {
        return new RemoveRepeatRule();
    }

    /**
     * Gets sort rule.
     * 
     * @return the sort rule.
     */
    @Bean
    @Scope("prototype")
    public Rule sortRule() {
        return new SortRule();
    }

    /**
     * Gets unordered list rule.
     * 
     * @return the unordered list rule.
     */
    @Bean
    @Scope("prototype")
    public Rule unordererListRule() {
        return new UnorderedListRule();
    }
    
    /**
     * Generate slideshow.
     * 
     * @param jsonPath   Json data file path.
     * @param htmlFolder Html file folder.
     */
    public final void generate(final String jsonPath, final String htmlFolder) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    JsonFileLoader jsonFileLoader =
                        FactoryManager.getBean("loader", JsonFileLoader.class);
                    SlideGeneration slideGeneration =
                        FactoryManager.getBean("generation", SlideGeneration.class);
                    HtmlFileSaver htmlFileSaver =
                        FactoryManager.getBean("saver", HtmlFileSaver.class);
                    
                    String jsonFile = new File(jsonPath).getName();
                    Slideshow slideshow = jsonFileLoader.load(jsonPath);
                    String html = slideGeneration.generate(slideshow);
                    String destinationPath =
                        htmlFolder
                            + jsonFile.substring(0, jsonFile.lastIndexOf("."))
                            + ".html";
                    
                    htmlFileSaver.save(html, destinationPath);
                    
                    Logger.getLogger(SlideshowGenerator.class)
                          .debug("Succeeded generate " + jsonPath + " to " + destinationPath);
                } catch (IOException exc) {
                    Logger.getLogger(SlideshowGenerator.class)
                          .error("Error while read file.", exc);
                }
            }
        }).start();
    }
}
