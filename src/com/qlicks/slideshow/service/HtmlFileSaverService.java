package com.qlicks.slideshow.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.qlicks.slideshow.dao.HtmlFileSaver;

/**
 * Html file saver service handler.
 * 
 * @author Erik P. Yuntantyo
 */
public final class HtmlFileSaverService implements HtmlFileSaver {
    @Override
    public void save(final String slideshowHtml, final String htmlPath) throws IOException {
        File file = new File(htmlPath);
        
        if (!file.exists()) {
            file.createNewFile();
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        
        writer.write(slideshowHtml);
        writer.flush();
        writer.close();
    }
}
