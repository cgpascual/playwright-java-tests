package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties prop;

    public ConfigReader() {

        prop = new Properties();

        try (InputStream input =
                     getClass().getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }

            prop.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}