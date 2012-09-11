package com.tmkm.tellmeajoke.utils;

import java.util.Properties;

public enum TellMeAJokeConstants {

	PATH_TO_JOKES("pathJokes");

	String value;
	
	static Properties p = new PropertiesLoader().loadConstantsFile();

	TellMeAJokeConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		
		return p.getProperty(value);
	}

}
