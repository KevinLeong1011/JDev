package com.dev.event;

import java.util.EventListener;

/**
 * ÊÂ¼ş¶©ÔÄÀà
 * @author Kevin
 *
 * @param <T> EventHandler
 */
public interface EventSubscriber<T extends EventSource<T>> extends EventListener {
	void doEvent(EventData<T> data);
}
