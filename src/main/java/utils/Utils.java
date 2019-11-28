package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public String getApplicationPropertyValue(String propertyKey) throws IOException {
        Properties p = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream("config/application.properties");
        p.load(is);
        String propertyValue = p.getProperty(propertyKey);
        is.close();
        return propertyValue;
    }
}
