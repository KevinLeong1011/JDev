package com.dev.event;

/**
 * һ�����¼����ģ�����˼�壬ÿ��ע���ֻ����һ��
 * 
 * @author Kevin
 *
 */
public interface OnceSubscriber<T extends EventSource<T>> extends EventSubscriber<T> {
}
