package main.java.com.codewithsatyam.utils;

import java.io.InputStream;
import java.util.Properties;

import main.java.com.codewithsatyam.jdbcTest.AppMain;

public class PropertyReader {
public static Properties getProperties(String filename) {
	
	Properties properties = new Properties();
	InputStream input=null;
	try {
		input=AppMain.class.getResourceAsStream(filename);
		System.out.println(" input: "+input + "filename: "+ filename);
		properties.load(input);
     for(String key: properties.stringPropertyNames()) {
    	 System.out.println(key + ": "+properties.getProperty(key));
     }
	} catch (Exception e) {
		System.out.println("Failed to load properties: "+ e.getMessage()+ e);
		e.printStackTrace();
	}
	return properties;
}

}
