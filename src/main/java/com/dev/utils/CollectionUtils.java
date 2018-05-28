package com.dev.utils;

import java.util.Collection;
import java.util.Iterator;

/**
 * ���Ϲ�����
 * 
 * @author liangchao
 *
 */
public final class CollectionUtils {
	private CollectionUtils() {
	}

	/**
	 * �жϼ����Ƿ�Ϊnull���
	 * 
	 * @param collection
	 * @return
	 */
	public static Boolean nullOrEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	/**
	 * ������ʹ�ø����ķָ���ת��Ϊ�ַ���
	 * @param collection ����
	 * @param delimiter �ָ���
	 * @return
	 */
	public static String toString(Collection<?> collection, String delimiter) {
		return toString(collection, delimiter, "", "");
	}

	/**
	 * ������ʹ�ø����ķָ�����ǰ׺����׺ת��Ϊ�ַ���
	 * @param collection ����
	 * @param delimiter �ָ���
	 * @param prefix ǰ׺
	 * @param suffix ��׺
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
