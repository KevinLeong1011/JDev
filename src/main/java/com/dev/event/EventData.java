package com.dev.event;

import java.util.EventObject;

/**
 * �¼�����
 * @author Kevin
 *
 * @param <T> �¼�Դ����
 */
public class EventData<T extends EventSource<T>> extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String state;

	private String message;

	/**
	 * ���캯��
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
	 * ��ȡ�¼�״̬
	 * 
	 * @return
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * ��ȡ�¼�Դ����
	 */
	@SuppressWarnings("unchecked")
	public T getSource() {
		return (T) this.source;
	}

	/**
	 * ��ȡ�¼���Ϣ
	 * @return
	 */
	public String getMessage() {
		return message;
	}
}
