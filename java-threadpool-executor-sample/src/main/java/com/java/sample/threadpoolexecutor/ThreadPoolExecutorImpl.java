package com.java.sample.threadpoolexecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * {@link ThreadPoolExecutorImpl} is a custom implementation of ThreadPool
 * executor to provide the custom implementations for life cycle hooks like
 * {@link #afterExecute(Runnable, Throwable)},
 * {@link #beforeExecute(Thread, Runnable)} and {@link #terminated()} methods
 * 
 * @see ThreadPoolExecutor
 * @author manjunathshetty
 *
 */
public class ThreadPoolExecutorImpl extends ThreadPoolExecutor {

	public ThreadPoolExecutorImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
	}

	public ThreadPoolExecutorImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
	}

	public ThreadPoolExecutorImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
	}

	public ThreadPoolExecutorImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("Before executing thread " + t.getName());
		//Handle ThreadLocals or any other initializations
		super.beforeExecute(t, r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("After executing thread ");
		super.afterExecute(r, t);
	}

	@Override
	protected void terminated() {
		System.out.println("Terminated thread ");
		super.terminated();
	}

}
