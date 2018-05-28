package com.dev.utils;

/**
 * �ַ���������
 * 
 * @author liangchao
 *
 */
public class StringUtils {
	private StringUtils() {
	}

	/**
	 * �ж��ַ����Ƿ�Ϊnull���
	 * @param str
	 * @return
	 */
	public static boolean nullOrEmpty(String str) {
		return (str == null || str.isEmpty());
	}

	/**
	 * �Ӹ������ַ��������з��ص�һ����Ϊnull����ַ�����ֵ
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
