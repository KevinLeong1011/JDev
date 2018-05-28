package com.dev.event;

import java.util.EventObject;

/**
 * 事件数据
 * @author Kevin
 *
 * @param <T> 事件源类型
 */
public class EventData<T extends EventSource<T>> extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String state;

	private String message;

	/**
	 * 构造函数
	 * 
	 * @param source
	 * @param state
	 */
	public EventData(T source, String state, String message) {
		super(source);
		this.state = state;
		this.message = message;
	}

	/**
	 * 获取事件状态
	 * 
	 * @return
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * 获取事件源对象
	 */
	@SuppressWarnings("unchecked")
	public T getSource() {
		return (T) this.source;
	}

	/**
	 * 获取事件消息
	 * @return
	 */
	public String getMessage() {
		return message;
	}
}
