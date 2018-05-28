package com.dev.utils;

/**
 * 校验数据，或者确保数据满足给定的条件
 * 
 * @author liangchao
 *
 */
public final class Guard {
	private Guard() {
	}

	/**
	 * 如果数据为null，则抛出异常
	 * @param obj
	 * @param name
	 */
	public static void throwIfNull(Object obj, String name) {
		if (obj == null) {
			throw new IllegalArgumentException(name);
		}
	}
}
