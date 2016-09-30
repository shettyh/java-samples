package com.manjunathshetty.httpclient;

import org.apache.http.HttpException;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.manjunathshetty.httpclient.common.HttpResponse;
/**
 * Http request tests
 * @author manjunatha_h
 *
 */
public class HttpClientTest {

	@Test(enabled = true)
	public void testGetRequest() throws HttpException {
		HttpClient client = new HttpClientImpl();
		HttpResponse response = client.get("https://www.google.co.in");
		assertEquals(200, response.getStatusCode());
	}

}
