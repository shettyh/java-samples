package com.java.sample.threadpoolexecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link CustomThreadFactoryBuilder} class used for building a custom thread
 * factory Customized name for threads , custom priority, deamon or not can be
 * customized
 * 
 * @see ThreadFactory
 * @author manjunathshetty
 *
 */
public class CustomThreadFactoryBuilder {

	private String namePrefix = "test-pool";
	private int priority = Thread.MAX_PRIORITY;
	private boolean deamon;
	private final static AtomicLong count = new AtomicLong(0);

	public ThreadFactory build() {
		return build(this);
	}

	private static ThreadFactory build(CustomThreadFactoryBuilder builder) {
		return (Runnable r) -> {
			Thread thread = new Thread(r);
			thread.setName(builder.namePrefix + "-" + count.getAndIncrement());
			thread.setDaemon(builder.deamon);
			thread.setPriority(builder.priority);
			return thread;
		};
	}

	public CustomThreadFactoryBuilder setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
		return this;
	}

	public CustomThreadFactoryBuilder setPriority(int priority) {
		this.priority = priority;
		return this;
	}

	public CustomThreadFactoryBuilder setDeamon(boolean deamon) {
		this.deamon = deamon;
		return this;
	}

}
