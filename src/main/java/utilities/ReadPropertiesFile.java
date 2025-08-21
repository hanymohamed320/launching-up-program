package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    private static final String ProductionData = System.getProperty("user.dir") +
            "\\src\\test\\resources\\configuration\\EnviromentCapabilities.properties";
    private static Properties configProperties;

    public static Properties getProperties() {
        if (configProperties == null) {
            configProperties = new Properties();
            try (FileInputStream inputStream = new FileInputStream(ProductionData)) {
                configProperties.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties file", e);
            }
        }
        return configProperties;
    }
}
