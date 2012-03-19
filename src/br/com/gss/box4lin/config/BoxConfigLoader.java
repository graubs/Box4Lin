/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.config;

import br.com.gss.box4lin.constants.ApplicationConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glauber
 */
public class BoxConfigLoader {

    private static BoxConfigLoader instance;
    Properties mimeProperties;

    private BoxConfigLoader() {
        mimeProperties = new Properties();
        try {
            mimeProperties.load(new FileInputStream(ApplicationConstants.MIME_TYPE_CONFIG_FILE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BoxConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BoxConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BoxConfigLoader getInstance() {
        if (instance == null) {
            instance = new BoxConfigLoader();
        }
        return instance;
    }

    public String getMimeTypeFileName(String key) {
        String fileName = mimeProperties.getProperty(key);
        if(fileName == null || fileName.length() == 0){
            fileName = ApplicationConstants.DEFAULT_ICON_FILE;
        }
        return fileName;
    }
}
