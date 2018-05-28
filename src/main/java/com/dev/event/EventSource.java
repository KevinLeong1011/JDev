package com.dev.event;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dev.utils.Guard;

/**
 * 事件源
 * @author Kevin
 *
 * @param <T>
 */
public abstract class EventSource<T extends EventSource<T>> {
	private Map<EventSubscriber<T>, Integer> listeners = new HashMap<EventSubscriber<T>, Integer>();

	private Map<RunnableSubscriber<T>, Integer> runnableListeners = new HashMap<RunnableSubscriber<T>, Integer>();

	private ExecutorService service;

	protected EventSource() {
	}

	/**
	 * 注册listener
	 * 
	 * @param listener
	 * @return
	 */
	public void register(EventSubscriber<T> listener) {
		Guard.throwIfNull(listener, "listener");
		if (listener instanceof RunnableSubscriber && !runnableListeners.containsKey(listener)) {
			runnableListeners.put((RunnableSubscriber<T>) listener, 0);
			return;
		}
		if (!listeners.containsKey(listener))
			listeners.put(listener, 0);
	}

	/**
	 * 移除listener
	 * 
	 * @param listener
	 * @return
	 */
	public void unregister(EventSubscriber<T> listener) {
		Guard.throwIfNull(listener, "listener");
		listeners.remove(listener);
	}

	/**
	 * 触发事件
	 * 
	 * @param state
	 */
	@SuppressWarnings("unchecked")
	protected void trigger(String state, String message) {
		if (service == null) {
			service = Executors.newCachedThreadPool();
		}
		@SuppressWarnings("rawtypes")
		final EventData<T> data = new EventData(this, state, message);
		for (final Map.Entry<RunnableSubscriber<T>, Integer> entry : runnableListeners.entrySet()) {
			service.submit(new Runnable() {
				public void run() {
					entry.getKey().doEvent(data);
				}
			});
		}

		for (Map.Entry<EventSubscriber<T>, Integer> entry : listeners.entrySet()) {
			EventSubscriber<T> listener = entry.getKey();
			boolean b = listener instanceof OnceSubscriber;
			int count = entry.getValue();
			if (b && count > 0) {
				continue;
			}
			listener.doEvent(data);
			listeners.put(listener, count + 1);
		}
	}
}
