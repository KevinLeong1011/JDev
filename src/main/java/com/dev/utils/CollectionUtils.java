package com.dev.utils;

import java.util.Collection;
import java.util.Iterator;

/**
 * 集合工具类
 * 
 * @author liangchao
 *
 */
public final class CollectionUtils {
	private CollectionUtils() {
	}

	/**
	 * 判断集合是否为null或空
	 * 
	 * @param collection
	 * @return
	 */
	public static Boolean nullOrEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	/**
	 * 将集合使用给定的分隔符转换为字符串
	 * @param collection 集合
	 * @param delimiter 分隔符
	 * @return
	 */
	public static String toString(Collection<?> collection, String delimiter) {
		return toString(collection, delimiter, "", "");
	}

	/**
	 * 将集合使用给定的分隔符、前缀、后缀转换为字符串
	 * @param collection 集合
	 * @param delimiter 分隔符
	 * @param prefix 前缀
	 * @param suffix 后缀
	 * @return
	 */
	public static String toString(Collection<?> collection, String delimiter, String prefix, String suffix) {
		if (CollectionUtils.nullOrEmpty(collection)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Iterator<?> it = collection.iterator();
		while (it.hasNext()) {
			sb.append(prefix).append(it.next()).append(suffix);
			if (it.hasNext()) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}
}
