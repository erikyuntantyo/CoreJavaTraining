package com.qlicks.slideshow.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import com.qlicks.slideshow.dao.JsonFileLoader;
import com.qlicks.slideshow.model.Slide;
import com.qlicks.slideshow.model.Slideshow;

/**
 * Json file loader service handler.
 * 
 * @author Erik P. Yuntantyo
 */
public final class JsonFileLoaderService implements JsonFileLoader {
    @Override
    public Slideshow load(final String jsonPath) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonPath)));
            JSONObject jsonObject = JSONObject.fromObject(json);
            Map<String, Class<?>> classMap = new HashMap<>();
            
            classMap.put("slides", Slide.class);
            
            return (Slideshow)JSONObject.toBean(jsonObject, Slideshow.class, classMap);
        } catch (FileNotFoundException exc) {
            Logger.getLogger(JsonFileLoader.class)
                  .error("File " + jsonPath + " cannot be found.", exc);
        } catch (IOException exc) {
            Logger.getLogger(JsonFileLoader.class)
                  .error("Error has been thrown while read json file.", exc);
        }
        
        return null;
    }
}
