package com.manjunathshetty.httpclient;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.apache.http.HttpResponse;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.protocol.HttpContext;

/**
 * Http Service Unavailable Handler
 * 
 * @author manjunatha_h
 *
 */
public class HttpServiceUnavailableHandler implements ServiceUnavailableRetryStrategy {

	private int retry = 1;
	private int retryInterval = 1;

	public HttpServiceUnavailableHandler() {
	}

	public HttpServiceUnavailableHandler(int retry, int retryInterval) {
		this.retry = retry;
		this.retryInterval = retryInterval;
	}

	@Override
	public boolean retryRequest(HttpResponse response, int executionCount, HttpContext context) {
		int statusCode = response.getStatusLine().getStatusCode();
		boolean statusRetry = (statusCode >= 200 && statusCode <= 300) ? false : true;
		return (statusRetry && (executionCount > retry));
	}

	@Override
	public long getRetryInterval() {
		return this.retryInterval * 60 * 1000;
	}

}
