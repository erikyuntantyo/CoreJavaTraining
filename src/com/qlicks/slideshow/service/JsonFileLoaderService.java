package com.qlicks.slideshow.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
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
    public Slideshow load(final String jsonPath) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(jsonPath)));
        JSONObject jsonObject = JSONObject.fromObject(json);
        Map<String, Class<?>> classMap = new HashMap<>();
        
        classMap.put("slides", Slide.class);
        
        return (Slideshow)JSONObject.toBean(jsonObject, Slideshow.class, classMap);
    }
}
