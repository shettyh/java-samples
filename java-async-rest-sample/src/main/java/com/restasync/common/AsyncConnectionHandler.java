package com.restasync.common;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.ConnectionCallback;

/**
 * @see ConnectionCallback
 * @author manjunatha_h
 *
 */
public class AsyncConnectionHandler implements ConnectionCallback {

	@Override
	public void onDisconnect(AsyncResponse disconnected) {
		System.out.println("Client disconnected");
		disconnected.cancel();
	}

}
