package com.manjunathshetty.httpclient.common;

/**
 * HttpResponse object
 * 
 * @author manjunatha_h
 *
 */
public class HttpResponse {

	private String responseString;
	private int statusCode;
	private String errorString;

	public HttpResponse() {
	}

	public HttpResponse(int statusCode, String response, String errorString) {
		this.statusCode = statusCode;
		this.responseString = response;
		this.errorString = errorString;
	}

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

}
