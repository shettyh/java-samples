package com.restasync.common;

import javax.ws.rs.container.CompletionCallback;

public class AsyncCompletionHandler implements CompletionCallback {

	@Override
	public void onComplete(Throwable throwable) {
		if (throwable == null)
			System.out.println("Request completed successfully");
		else {
			System.out.println("Request failed with exception :" + throwable.getMessage());
			throwable.printStackTrace();
		}
	}

}
