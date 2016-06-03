package com.snowstore.bootAdmin.service.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 用于读取国际化消息文件
 * 
 * @author SM
 * 
 */
public class PropertiesReader {

	private static ResourceBundle cache;
	static {
		reload();
	}

	/**
	 * 根据指定的key获取value
	 * 
	 * @param key
	 * @return
	 */
	public static String readAsString(String key) {
		if (cache == null) {
			reload();
		}
		try {
			return cache.getString(key);
		} catch (Exception e) {
			return key;
		}

	}

	/**
	 * 初始化并读取properties文件内容到cache中
	 */
	private final static void reload() {
		cache = ResourceBundle.getBundle("message");
	}

	/**
	 * 
	 * @description: 替换占位符
	 * @author: wujinsong
	 * @param key
	 * @param repStr
	 * @return
	 */
	public final static String readAsStringAndSetValue(String key, Object... repStr) {
		return MessageFormat.format(readAsString(key), repStr);
	}
}
