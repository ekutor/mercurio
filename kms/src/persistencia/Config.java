package co.com.personalsoft.base.db;

import java.util.ResourceBundle;

public class Config {
	private static ResourceBundle config = ResourceBundle.getBundle("config");

	public static ResourceBundle get() {
		return config;
	}
}
