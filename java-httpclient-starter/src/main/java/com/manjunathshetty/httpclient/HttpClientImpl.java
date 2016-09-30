package com.manjunathshetty.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import com.manjunathshetty.httpclient.common.HttpResponse;

/**
 * HttpClient implementation
 * 
 * @see HttpClient
 * @author manjunatha_h
 *
 */
public class HttpClientImpl implements HttpClient {

	private org.apache.http.client.HttpClient _Client;

	public HttpClientImpl(int retry, int retryInterval) {
		_Client = HttpClients.custom().setRetryHandler(new HttpRetryManager(retry, retryInterval))
				.setServiceUnavailableRetryStrategy(new HttpServiceUnavailableHandler(retry, retryInterval)).build();
	}

	public HttpClientImpl() {
		_Client = HttpClients.custom().setRetryHandler(new HttpRetryManager())
				.setServiceUnavailableRetryStrategy(new HttpServiceUnavailableHandler()).build();
	}

	@Override
	public HttpResponse get(String url) throws HttpException {

		HttpGet getRequest = new HttpGet(url);
		try {
			org.apache.http.HttpResponse response = _Client.execute(getRequest);
			HttpResponse httpResponse = new HttpResponse();
			httpResponse.setStatusCode(response.getStatusLine().getStatusCode());
			httpResponse.setErrorString(response.getStatusLine().getReasonPhrase());
			httpResponse.setResponseString(readInputStream(response.getEntity().getContent()));
			return httpResponse;
		} catch (Exception e) {
			throw new HttpException(e.getMessage(), e);
		}
	}

	@Override
	public HttpResponse post(String url, String data) throws HttpException {
		HttpPost postRequest = new HttpPost(url);
		try {
			StringEntity entity = new StringEntity(data);
			entity.setContentType("text/plain");
			postRequest.setEntity(entity);
			org.apache.http.HttpResponse response = _Client.execute(postRequest);
			HttpResponse httpResponse = new HttpResponse();
			httpResponse.setStatusCode(response.getStatusLine().getStatusCode());
			httpResponse.setErrorString(response.getStatusLine().getReasonPhrase());
			httpResponse.setResponseString(readInputStream(response.getEntity().getContent()));
			return httpResponse;
		} catch (Exception e) {
			throw new HttpException(e.getMessage(), e);
		}
	}

	private String readInputStream(InputStream inputStream) throws IOException {
		StringBuilder output = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				output.append(line);
			}
		} finally {
			if (br != null)
				br.close();
		}
		return output.toString();
	}

}
