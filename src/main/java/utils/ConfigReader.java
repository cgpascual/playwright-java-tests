package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {

        prop = new Properties();

        try {

            FileInputStream fis =
                    new FileInputStream("src/main/resources/config.properties");

            prop.load(fis);

        } catch (Exception e) {

            System.err.println("Failed to load config file: " + e.getMessage());
        }

    }

    public String get(String key) {
        return prop.getProperty(key);
    }

}