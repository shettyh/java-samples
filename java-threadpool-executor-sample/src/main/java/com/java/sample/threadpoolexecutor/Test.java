package com.java.sample.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {

		Callable<Integer> task = () -> {
			IntStream.range(0, 10).forEach(i -> {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			return 1;
		};

		ThreadPoolExecutorImpl threadPoolExecutorImpl = new ThreadPoolExecutorImpl(3, 20, 1, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(10), new CustomThreadFactoryBuilder().build(),
				new RejectedExecutionHandlerImpl());

		IntStream.range(0, 100).forEach(i -> {
			threadPoolExecutorImpl.submit(task);
		});

		System.out.println("Done");

	}

}
