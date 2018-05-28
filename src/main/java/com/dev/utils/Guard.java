package com.dev.utils;

/**
 * У�����ݣ�����ȷ�������������������
 * 
 * @author liangchao
 *
 */
public final class Guard {
	private Guard() {
	}

	/**
	 * �������Ϊnull�����׳��쳣
	 * @param obj
	 * @param name
	 */
	public static void throwIfNull(Object obj, String name) {
		if (obj == null) {
			throw new IllegalArgumentException(name);
		}
	}
}
