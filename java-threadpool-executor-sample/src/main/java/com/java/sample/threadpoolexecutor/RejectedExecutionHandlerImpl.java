package com.java.sample.threadpoolexecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * @see RejectedExecutionHandlerImpl
 * @author manjunathshetty
 */
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("Rejected task");
		// Handle rejected ask here
	}

}
