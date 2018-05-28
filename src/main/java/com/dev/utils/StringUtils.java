package com.dev.utils;

/**
 * 字符串工具类
 * 
 * @author liangchao
 *
 */
public class StringUtils {
	private StringUtils() {
	}

	/**
	 * 判断字符串是否为null或空
	 * @param str
	 * @return
	 */
	public static boolean nullOrEmpty(String str) {
		return (str == null || str.isEmpty());
	}

	/**
	 * 从给定的字符串数组中返回第一个不为null或空字符串的值
	 * @param values
	 * @return
	 */
	public static String or(String... values) {
		for (String value : values) {
			if (!nullOrEmpty(value))
				return value;
		}
		return null;
	}
}
