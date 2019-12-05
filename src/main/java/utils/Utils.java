package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    private static final Logger LOG = LogManager.getLogger(Utils.class);
    private static final String PROPERTIES_PATH = "config/application.properties";
    private static Properties p = null;

    public static String getProperty(String propertyKey) {
        try {
            return getPropertiesFile().getProperty(propertyKey);
        } catch (IOException e) {
            LOG.error("Properties file not found ...");
            return "";
        }
    }

    public static String[] getProperties(String propertyKey) {
        try {
            return getPropertiesFile().getProperty(propertyKey).split(",");
        } catch (IOException e) {
            LOG.error("Properties file not found ...");
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
