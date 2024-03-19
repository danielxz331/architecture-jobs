/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractfactory.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author daniel
 */
public class PropertiesUtil {

    public static Properties loadProperty(String filePath) {
    Properties prop = new Properties();
    try (InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath)) {
        if (input == null) {
            throw new FileNotFoundException("Property file '" + filePath + "' not found in the classpath");
        }
        prop.load(input);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return prop;
}
}
