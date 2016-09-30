package com.restasync.common;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * @see TimeoutHandler
 * @author manjunatha_h
 *
 */
public class AsyncTimeoutHandler implements TimeoutHandler {

	@Override
	public void handleTimeout(AsyncResponse asyncResponse) {
		asyncResponse.resume(Response.status(Status.SERVICE_UNAVAILABLE).entity("Server is busy").build());
	}

}
