package com.manjunathshetty.httpclient;

import java.io.IOException;

import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

/**
 * Http request retry manager
 * @author manjunatha_h
 *
 */
public class HttpRetryManager implements HttpRequestRetryHandler {

	private int retry = 1;
	private int retryInterval;

	public HttpRetryManager() {
	}

	public HttpRetryManager(int retry, int retryInterval) {
		this.retry = retry;
		this.retryInterval = retryInterval;
	}

	@Override
	public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
		System.out.println("Failed to execute the HttpRequest " + (String) context.getAttribute("requestURI")
				+ " with error " + exception.getMessage());
		try {Thread.sleep(retryInterval * 60 * 1000);} catch (InterruptedException e) {}
		return (executionCount < retry);
	}

}
