package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	/** 类对象 */
	private static ConfigManager cm;
	/** 配置对象 */
	private Properties p;
	/** 私有化构造方法并进行初始化 */
	private ConfigManager() {
		 p =new Properties();
		 InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		 try {
			 p.load(is);
			 is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static synchronized ConfigManager getInstance() {
		if(cm == null) {
			cm = new ConfigManager();
		}
		return cm;
	}
	/** 获取配置文件的内容 */
	public  String getString(String name) {
		return p.getProperty(name); 
	} 
}
