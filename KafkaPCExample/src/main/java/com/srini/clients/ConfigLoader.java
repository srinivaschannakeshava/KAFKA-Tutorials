package com.srini.clients;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	private static ConfigLoader configLoader;
	public static Properties prodConfigProps;
	public static Properties consConfigProps;

	private ConfigLoader() {

	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
			prodConfigProps = configLoader.getConfigProps("prodConfig");
			consConfigProps = configLoader.getConfigProps("consConfig");
		}
		return configLoader;
	}

	public Properties getConfigProps(String propFile) {

		try {
			InputStream inputStream;
			Properties prop = new Properties();
			String propFileName = propFile + ".properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
				return prop;
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
