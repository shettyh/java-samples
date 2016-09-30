package com.manjunathshetty.httpclient;

import org.apache.http.HttpException;

import com.manjunathshetty.httpclient.common.HttpResponse;

/**
 * Custom HttpClient interface
 * 
 * @author manjunatha_h
 *
 */
interface HttpClient {

	public HttpResponse get(String url) throws HttpException;

	public HttpResponse post(String url, String data) throws HttpException;

}
