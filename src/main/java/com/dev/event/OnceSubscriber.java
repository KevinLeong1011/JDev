package com.dev.event;

/**
 * 一次性事件订阅，顾名思义，每次注册后只触发一次
 * 
 * @author Kevin
 *
 */
public interface OnceSubscriber<T extends EventSource<T>> extends EventSubscriber<T> {
}
