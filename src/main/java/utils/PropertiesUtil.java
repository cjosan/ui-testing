package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static final String PROPERTIES_PATH = "src//main//java//config/config.properties";
	private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

	private static Properties properties = loadProperties();

	private static Properties loadProperties() {
		Properties prop = new Properties();

		try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
			prop.load(input);

			logger.info("Successfully loaded properties from " + PROPERTIES_PATH);
		} catch (IOException ex) {
			logger.error("Failed to load properties from " + PROPERTIES_PATH, ex);
		}

		return prop;
	}

	public static String getProperty(String name) {
		return properties.get(name).toString();
	}
}
