package com.restasync.rest;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.restasync.common.AsyncCompletionHandler;
import com.restasync.common.AsyncConnectionHandler;
import com.restasync.common.AsyncTimeoutHandler;

/**
 * Asynchronous RESTFul API
 * 
 * @author manjunatha_h
 *
 */
@Path("async")
public class AsyncAPI {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void getDataAsync(@Suspended AsyncResponse response) {

		response.setTimeout(2, TimeUnit.MINUTES);
		response.register(AsyncTimeoutHandler.class, AsyncCompletionHandler.class, AsyncConnectionHandler.class);
		
		new Thread(() -> {
			System.out.println("Running Task");
			// Do the long running task here
			try {Thread.sleep(2000);} catch (InterruptedException e) {} /*To simulate the task*/
			System.out.println("Task Done");
			response.resume(Response.status(Status.OK).build());
		}).start();
	}

}
