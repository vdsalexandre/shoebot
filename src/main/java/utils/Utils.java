package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    private static final String PROPERTIES_PATH = "config/application.properties";
    private static Properties p = null;

    public static String getProperty(String propertyKey) {
        try {
            Properties properties = getPropertiesFile();
            return properties.getProperty(propertyKey);
        } catch (IOException e) {
            System.err.println("Properties file not found ...");
            return "";
        }
    }

    public static String[] getProperties(String propertyKey) {
        try {
            Properties properties = getPropertiesFile();
            return properties.getProperty(propertyKey).split(",");
        } catch (IOException e) {
            System.err.println("Properties file not found ...");
            return null;
        }
    }

    private static Properties getPropertiesFile() throws IOException {
        if (p == null) {
            p = new Properties();
            InputStream is = Utils.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH);
            p.load(is);
            is.close();
        }
        return p;
    }
}
