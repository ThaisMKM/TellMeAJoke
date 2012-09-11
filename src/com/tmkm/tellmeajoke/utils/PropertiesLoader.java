package com.tmkm.tellmeajoke.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesLoader {

	public static String CONSTANTS_PROPERTIES = File.separatorChar	+ "constants.properties";

	private static Logger logger = Logger.getLogger(PropertiesLoader.class
			.getPackage().getName());

	public Properties loadConstantsFile(){
		return load(CONSTANTS_PROPERTIES);
	}
	
	//load a file that is inside the project, in the first level inside the source folder
	public Properties load(String propertiesFileName){
		Properties properties = new Properties();
		// impl to be outside jar package: properties.load(new FileInputStream(new File(propertiesFileName)));

		
		try { 
			properties.load(PropertiesLoader.class
					.getResourceAsStream(propertiesFileName));
		} catch (IOException e) {
			logger.log(Level.SEVERE, " Could not load properties file -> "
					+ propertiesFileName +  " TERMINATING THE APPLICATION");
			System.exit(0);
		}

		return properties;

	}
}
